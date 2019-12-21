package com.sharaga.yourcityevents_android.modules.auth.signup.presenter

import android.os.Bundle
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.extensions.loadFragment
import com.sharaga.yourcityevents_android.extensions.showError
import com.sharaga.yourcityevents_android.modules.auth.AuthActivity
import com.sharaga.yourcityevents_android.modules.auth.signup.view.Signup3Fragment
import com.sharaga.yourcityevents_android.utility.KeyConstants
import java.lang.ref.WeakReference

class Signup2Presenter(private var authActivity: WeakReference<AuthActivity?>) {

    fun nextSignupStep(firstName: String, lastName: String) {
        if (firstName.isNotBlank() && lastName.isNotBlank()) {
            val bundle = Bundle()
            bundle.putString(KeyConstants.FIRST_NAME, firstName)
            bundle.putString(KeyConstants.LAST_NAME, lastName)

            val signup3Fragment = Signup3Fragment()
            signup3Fragment.arguments = bundle
            authActivity.get()?.loadFragment(signup3Fragment, R.id.auth_container)
        } else {
            authActivity.get()?.showError("name and surname shouldnt be blank")
        }
    }
}
