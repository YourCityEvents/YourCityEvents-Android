package com.sharaga.yourcityevents_android.modules.welcome.presenter

import com.sharaga.yourcityevents_android.extensions.switchToActivity
import com.sharaga.yourcityevents_android.modules.auth.login.view.LoginActivity
import com.sharaga.yourcityevents_android.modules.mainbar.MainBarActivity
import com.sharaga.yourcityevents_android.modules.welcome.view.WelcomeActivity
import com.sharaga.yourcityevents_android.network.ApiFactory
import com.sharaga.yourcityevents_android.security.AppUser
import com.sharaga.yourcityevents_android.security.UserCreds
import com.sharaga.yourcityevents_android.validators.EmailValidator
import com.sharaga.yourcityevents_android.validators.PasswordValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class WelcomePresenter(private val welcomeActivity: WeakReference<WelcomeActivity>) {

    private val identityService = ApiFactory.identityApi
    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()

    fun authUser() {
        val user = AppUser.getCurrentUserCreds()

        if (emailValidator.validate(user.login) && passwordValidator.validate(user.password)) {
            makeLoginRequest(user)
        } else {
            welcomeActivity.get()?.switchToActivity(LoginActivity::class.java)
        }
    }

    private fun makeLoginRequest(user: UserCreds) {
        GlobalScope.launch(Dispatchers.Main) {
            val loginRequest = identityService.loginAsync(user)

            try {
                val response = loginRequest.await()

                if (response.isSuccessful) {
                    if (response.body()!!.result) {
                        AppUser.setCurrentUserCreds(
                            user.login,
                            user.password,
                            response.body()?.data!!.token
                        )
                        welcomeActivity.get()?.switchToActivity(MainBarActivity::class.java)
                    } else {
                        welcomeActivity.get()?.switchToActivity(LoginActivity::class.java)
                    }
                } else {
                    welcomeActivity.get()?.switchToActivity(LoginActivity::class.java)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
