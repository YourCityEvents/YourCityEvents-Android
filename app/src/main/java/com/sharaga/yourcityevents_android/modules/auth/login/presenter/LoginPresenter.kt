package com.sharaga.yourcityevents_android.modules.auth.login.presenter
import com.sharaga.yourcityevents_android.extensions.showError
import com.sharaga.yourcityevents_android.modules.auth.login.view.LoginFragment
import com.sharaga.yourcityevents_android.security.AppUser
import com.sharaga.yourcityevents_android.service.ApiFactory
import com.sharaga.yourcityevents_android.service.validators.EmailValidator
import com.sharaga.yourcityevents_android.service.validators.PasswordValidator
import java.lang.ref.WeakReference

interface ILoginPresenter {
    fun login(email: String, password: String)
}

class LoginPresenter(private var view: WeakReference<LoginFragment>) : ILoginPresenter {

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()
    private val identityApi = ApiFactory.identityApi

    override fun login(email: String, password: String) {
        if (emailValidator.validate(email) && passwordValidator.validate(password)) {
            identityApi.login(AppUser.current)






        } else {
            view.get()?.showError("invalid")
        }
    }
}