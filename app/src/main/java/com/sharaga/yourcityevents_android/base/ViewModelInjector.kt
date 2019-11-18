package com.sharaga.yourcityevents_android.base

import com.sharaga.yourcityevents_android.modules.welcome.WelcomeVM
import com.sharaga.yourcityevents_android.service.ApiFactory
import com.sharaga.yourcityevents_android.service.api.CityApi
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

}
