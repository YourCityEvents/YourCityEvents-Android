package com.sharaga.yourcityevents_android.modules.welcome.presenter

import com.sharaga.yourcityevents_android.extensions.switchToActivity
import com.sharaga.yourcityevents_android.modules.auth.login.view.LoginActivity
import com.sharaga.yourcityevents_android.modules.mainbar.MainBarActivity
import com.sharaga.yourcityevents_android.modules.welcome.view.WelcomeActivity
import com.sharaga.yourcityevents_android.network.ApiFactory
import com.sharaga.yourcityevents_android.security.AppUser
import com.sharaga.yourcityevents_android.security.UserCreds
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class WelcomePresenter(private val activityWelcome: WeakReference<WelcomeActivity>) {

    private val identityService = ApiFactory.identityApi

    fun authUser() {
        val user = AppUser.getCurrentUserCreds()

        if (user.login.isNotBlank()) {
            makeLoginRequest(user)
        } else {
            activityWelcome.get()?.switchToActivity(LoginActivity::class.java)
        }
    }

    private fun makeLoginRequest(user: UserCreds) {
        GlobalScope.launch(Dispatchers.Default) {
            val loginRequest = identityService.loginAsync(user)

            try {
                val response = loginRequest.await()

                if (response.isSuccessful) {
                    AppUser.setCurrentUserCreds(
                        user.login,
                        user.password,
                        response.body()?.data!!.token
                    )
                    activityWelcome.get()?.switchToActivity(MainBarActivity::class.java)
                } else {
                    activityWelcome.get()?.switchToActivity(LoginActivity::class.java)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
