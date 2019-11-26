package com.sharaga.yourcityevents_android.modules.auth.login.view

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.auth.login.presenter.LoginPresenter
import com.sharaga.yourcityevents_android.modules.mainbar.MainBarActivity
import kotlinx.android.synthetic.main.login_fragment1.*
import java.lang.ref.WeakReference

class LoginActivity : AppCompatActivity() {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment1)
        this.presenter = LoginPresenter(WeakReference(this))

        sign_in.setOnClickListener {
            val intent = Intent(this, MainBarActivity::class.java)
//            val intent = Intent(this, MainBarActivity.class)
            startActivity(intent)
        }

        sign_up.setOnClickListener {

        }
    }
}


class LoginFragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment1, container, false)
    }
}