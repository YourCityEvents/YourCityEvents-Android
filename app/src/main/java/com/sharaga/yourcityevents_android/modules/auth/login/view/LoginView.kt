package com.sharaga.yourcityevents_android.modules.auth.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.auth.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.login_fragment1.*
import java.lang.ref.WeakReference

class LoginActivity : AppCompatActivity() {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)


        loadFragment(LoginFragment())


    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.loginContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
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
        //var view; //inflater.inflate(R.layout.login_fragment1, container, false)


        return inflater.inflate(R.layout.login_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)


        sign_up.setOnClickListener{
            presenter.cumshot()
        }

        sign_in.setOnClickListener {
            //            val intent = Intent(activity, MainBarActivity::class.java)
//            startActivity(intent)
            presenter.login("", "")
        }
    }
}