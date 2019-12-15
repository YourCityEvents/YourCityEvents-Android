package com.sharaga.yourcityevents_android.modules.auth.login.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.extensions.loadFragment
import com.sharaga.yourcityevents_android.modules.auth.login.presenter.LoginPresenter
import com.sharaga.yourcityevents_android.modules.mainbar.MainBarActivity
import kotlinx.android.synthetic.main.fragment_login.*
import java.lang.ref.WeakReference

class LoginActivity : AppCompatActivity() {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
        loadFragment(LoginFragment())
    }
}


class LoginFragment : Fragment() {
    lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this.presenter = LoginPresenter(WeakReference(this))
        //var view; //inflater.inflate(R.layout.fragment_login, container, false)

        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        sign_up.setOnClickListener{
            presenter.cumshot()
        }

        sign_in.setOnClickListener {
                        val intent = Intent(activity, MainBarActivity::class.java)
            startActivity(intent)
            presenter.login("", "")
        }
    }
}