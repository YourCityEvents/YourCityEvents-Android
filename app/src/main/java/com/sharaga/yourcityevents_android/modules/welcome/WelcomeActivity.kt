package com.sharaga.yourcityevents_android.modules.welcome

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.auth.login.view.LoginActivity


class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        Handler().postDelayed({
            authUser()
        }, 2000)
    }

    private fun authUser() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}
