package com.sharaga.yourcityevents_android.modules.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.extensions.loadFragment
import com.sharaga.yourcityevents_android.modules.auth.login.view.LoginFragment

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
        loadFragment(LoginFragment(), R.id.auth_container)
    }
}
