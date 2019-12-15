package com.sharaga.yourcityevents_android.modules.welcome.presenter

import com.sharaga.yourcityevents_android.extensions.switchToActivity
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
//        activi
        AppUser.setCurrentUserCreds(
            "yarykloh2@example.com",
            "string",
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ5YXJ5a2xvaDJAZXhhbXBsZS5jb20iLCJqdGkiOiJkYzcxNmMzNC04ZGE5LTRhYWUtYjI0Ny1lMmNiNTE3NDM0YWQiLCJlbWFpbCI6InlhcnlrbG9oMkBleGFtcGxlLmNvbSIsIm5iZiI6MTU3NjM1NTM4MywiZXhwIjoxNTc2MzYyNTgzLCJpYXQiOjE1NzYzNTUzODN9._M-JZIUufAb-sBlEWuqP49zsl2PwtMD6_GgaYFqd4qk"
        )
        val user = AppUser.getCurrentUserCreds()

        if (user.login.isNotBlank()) {
            makeLoginRequest(user)
        } else {
//            switchToActivity(LoginActivity::class.java)
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
//                    switchToActivity(LoginActivity::class.java)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
