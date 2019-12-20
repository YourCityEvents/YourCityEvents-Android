package com.sharaga.yourcityevents_android.modules.auth.signup.presenter

import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.extensions.loadFragment
import com.sharaga.yourcityevents_android.extensions.showError
import com.sharaga.yourcityevents_android.modules.auth.AuthActivity
import com.sharaga.yourcityevents_android.modules.auth.signup.view.Signup2Fragment
import com.sharaga.yourcityevents_android.security.AppUser
import com.sharaga.yourcityevents_android.validators.EmailValidator
import com.sharaga.yourcityevents_android.validators.PasswordValidator
import java.lang.ref.WeakReference

class Signup1Presenter(private var authActivity: WeakReference<AuthActivity?>) {

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()

    fun nextSignupStep(email: String, password: String) {
        if (emailValidator.validate(email) && passwordValidator.validate(password)) {
            AppUser.setCurrentUserCreds(email, password)

            authActivity.get()?.loadFragment(Signup2Fragment(), R.id.auth_container)
        } else {
            authActivity.get()?.showError("invalid email or password")
        }
    }
}
