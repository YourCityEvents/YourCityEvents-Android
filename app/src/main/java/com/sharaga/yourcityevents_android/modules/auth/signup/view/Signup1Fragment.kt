package com.sharaga.yourcityevents_android.modules.auth.signup.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.extensions.loadFragment
import com.sharaga.yourcityevents_android.modules.auth.AuthActivity
import com.sharaga.yourcityevents_android.modules.auth.login.view.LoginFragment
import com.sharaga.yourcityevents_android.modules.auth.signup.presenter.Signup1Presenter
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_signup1.view.*
import java.lang.ref.WeakReference

class Signup1Fragment : Fragment() {

    private lateinit var presenter: Signup1Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = Signup1Presenter(WeakReference(activity as AuthActivity))
        return inflater.inflate(R.layout.fragment_signup1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sign_in.setOnClickListener{
            (activity as AuthActivity).loadFragment(LoginFragment(), R.id.auth_container)
        }

        next.setOnClickListener{
            presenter.nextSignupStep(view.email.text.toString(), view.password.text.toString())
        }
    }
}
