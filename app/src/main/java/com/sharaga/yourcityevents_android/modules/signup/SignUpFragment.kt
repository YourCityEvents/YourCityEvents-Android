package com.sharaga.yourcityevents_android.modules.signup

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders

class SignUpFragment: FragmentActivity() {

    private lateinit var viewModel: SignUpVM

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel = ViewModelProviders.of(this).get(SignUpVM::class.java)
    }

}