package com.sharaga.yourcityevents_android.modules.auth.login.presenter
import com.sharaga.yourcityevents_android.extensions.showError
import com.sharaga.yourcityevents_android.modules.auth.login.view.LoginFragment
import com.sharaga.yourcityevents_android.service.validators.EmailValidator
import com.sharaga.yourcityevents_android.service.validators.PasswordValidator
import java.lang.ref.WeakReference

interface ILoginPresenter {
    fun login(email: String, password: String)
}

class LoginPresenter(private var view: WeakReference<LoginFragment>) : ILoginPresenter {

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()


    override fun login(email: String, password: String) {
        if (emailValidator.validate(email) && passwordValidator.validate(password)) {
            //TO DO: login user
        } else {
            view.get()?.showError("invalid")
//                view.showError("Field all fields")
        }
    }
}