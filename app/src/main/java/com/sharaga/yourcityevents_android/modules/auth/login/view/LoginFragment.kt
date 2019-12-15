package com.sharaga.yourcityevents_android.modules.auth.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.auth.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import java.lang.ref.WeakReference

class LoginFragment : Fragment() {

    lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.presenter = LoginPresenter(WeakReference(activity as LoginActivity))
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sign_up.setOnClickListener{
            presenter.cumshot()
        }

        sign_in.setOnClickListener {
            presenter.signIn(view.email.text.toString(), view.password.text.toString())
        }
    }
}
