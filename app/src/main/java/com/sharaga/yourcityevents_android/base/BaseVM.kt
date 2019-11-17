package com.sharaga.yourcityevents_android.base

import androidx.lifecycle.ViewModel
import com.sharaga.yourcityevents_android.modules.welcome.WelcomeVM

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is WelcomeVM -> injector.inject(this)
        }
    }
}