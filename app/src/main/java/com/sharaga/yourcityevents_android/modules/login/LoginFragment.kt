package com.sharaga.yourcityevents_android.modules.login

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders

class LoginFragment: FragmentActivity() {


    private lateinit var viewModel: LoginVM

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel = ViewModelProviders.of(this).get(LoginVM::class.java)

    }
}