package com.sharaga.yourcityevents_android.modules.auth.login.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.extensions.loadFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
        loadFragment(LoginFragment(), R.id.loginContainer)
    }
}
