package com.sharaga.yourcityevents_android.base

import com.sharaga.yourcityevents_android.modules.welcome.WelcomeVM
import dagger.Component
import javax.inject.Singleton

@Singleton
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param welcomeViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(welcomeViewModel: WelcomeVM)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
    }
}
