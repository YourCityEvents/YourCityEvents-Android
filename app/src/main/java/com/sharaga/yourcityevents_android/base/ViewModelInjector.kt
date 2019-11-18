package com.sharaga.yourcityevents_android.base

import com.sharaga.yourcityevents_android.modules.login.LoginVM
import com.sharaga.yourcityevents_android.modules.signUp.SignUpVM
import com.sharaga.yourcityevents_android.modules.welcome.WelcomeVM
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(WelcomeVM::class))
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param welcomeViewModel PostListViewModel in which to inject the dependencies
     */

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
    }

    fun inject(welcomeViewModel: WelcomeVM)
    fun inject(loginViewModel: LoginVM)
    fun inject(signUpViewModel: SignUpVM)

}
