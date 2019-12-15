package com.sharaga.yourcityevents_android.modules.welcome.view

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.welcome.presenter.WelcomePresenter
import java.lang.ref.WeakReference

class WelcomeActivity : AppCompatActivity() {

    private lateinit var presenter: WelcomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        this.presenter = WelcomePresenter(WeakReference(this) )
        Handler().postDelayed({
            this.presenter.authUser()
        }, 2000)
    }
}
