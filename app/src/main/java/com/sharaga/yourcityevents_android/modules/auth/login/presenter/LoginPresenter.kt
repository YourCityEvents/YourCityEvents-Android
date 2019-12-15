package com.sharaga.yourcityevents_android.modules.auth.login.presenter

import com.sharaga.yourcityevents_android.extensions.showError
import com.sharaga.yourcityevents_android.extensions.switchToActivity
import com.sharaga.yourcityevents_android.modules.auth.login.view.LoginActivity
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

class LoginPresenter(private var loginActivity: WeakReference<LoginActivity?>) {

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()
    private val identityService = ApiFactory.identityApi

    fun signIn(email: String, password: String) {
        if (emailValidator.validate(email) && passwordValidator.validate(password)) {
            //identityApi.login(AppUser.current)
            makeLoginRequest(UserCreds(email, password))
//            model.setCurrentUserCreds(email)
            //  networking.loginogin()
        } else {
            loginActivity.get()?.showError("invalid email or password")
        }
    }

    fun cumshot() {
        //userRepository.save(RealmUser("228", "ldsf", "ldsjf", "lsdfj", "dlskfj", "ldsfk", RealmList(), RealmList(), "ldsf", "ldsf"))
//        view.get()?.showError(userRepository.getById("228").toString())
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
                        loginActivity.get()?.switchToActivity(MainBarActivity::class.java)
                    } else {
                        loginActivity.get()?.showError(response.body()!!.errors)
                    }
                } else {
                    loginActivity.get()?.showError("smert' backend or no connection")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
