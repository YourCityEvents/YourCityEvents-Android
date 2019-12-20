package com.sharaga.yourcityevents_android.modules.auth.signup.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.auth.AuthActivity
import com.sharaga.yourcityevents_android.modules.auth.signup.presenter.Signup2Presenter
import kotlinx.android.synthetic.main.fragment_signup2.*
import kotlinx.android.synthetic.main.fragment_signup2.view.*
import java.lang.ref.WeakReference

class Signup2Fragment : Fragment() {

    private lateinit var presenter: Signup2Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = Signup2Presenter(WeakReference(activity as AuthActivity))
        return inflater.inflate(R.layout.fragment_signup2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        next.setOnClickListener {
            presenter.nextSignupStep(
                view.first_name.text.toString(),
                view.last_name.text.toString()
            )
        }
    }
}
