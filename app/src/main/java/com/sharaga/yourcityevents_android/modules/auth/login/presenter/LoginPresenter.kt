package com.sharaga.yourcityevents_android.modules.auth.login.presenter
import com.sharaga.yourcityevents_android.extensions.showError
import com.sharaga.yourcityevents_android.modules.auth.login.view.LoginActivity
import com.sharaga.yourcityevents_android.service.validators.EmailValidator
import com.sharaga.yourcityevents_android.service.validators.PasswordValidator

interface ILoginPresenter {
    fun login(email: String, password: String)
}

class LoginPresenter(private var view: LoginActivity) : ILoginPresenter {

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()

    override fun login(email: String, password: String) {
        if (emailValidator.validate(email) && passwordValidator.validate(password)) {
            //TO DO: login user
        }else {
            view.showError("Field all fields")
        }
    }
}