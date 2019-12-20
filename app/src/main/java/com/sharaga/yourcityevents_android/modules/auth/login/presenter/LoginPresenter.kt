package com.sharaga.yourcityevents_android.modules.auth.login.presenter

import com.sharaga.yourcityevents_android.extensions.showError
import com.sharaga.yourcityevents_android.extensions.switchToActivity
import com.sharaga.yourcityevents_android.modules.auth.AuthActivity
import com.sharaga.yourcityevents_android.modules.mainbar.MainBarActivity
import com.sharaga.yourcityevents_android.network.ApiFactory
import com.sharaga.yourcityevents_android.security.AppUser
import com.sharaga.yourcityevents_android.security.UserCreds
import com.sharaga.yourcityevents_android.validators.EmailValidator
import com.sharaga.yourcityevents_android.validators.PasswordValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class LoginPresenter(private var authActivity: WeakReference<AuthActivity?>) {

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()
    private val identityService = ApiFactory.identityApi

    fun signIn(email: String, password: String) {
        if (emailValidator.validate(email) && passwordValidator.validate(password)) {
            makeLoginRequest(UserCreds(email, password))
        } else {
            authActivity.get()?.showError("invalid email or password")
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
                        authActivity.get()?.switchToActivity(MainBarActivity::class.java)
                    } else {
                        authActivity.get()?.showError(response.body()!!.errors)
                    }
                } else {
                    authActivity.get()?.showError("smert' backend or no connection")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
