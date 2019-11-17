package com.sharaga.yourcityevents_android.modules.welcome

import com.sharaga.yourcityevents_android.base.BaseViewModel
import com.sharaga.yourcityevents_android.service.ApiFactory
import io.reactivex.disposables.Disposable
import javax.inject.Inject


class WelcomeVM: BaseViewModel() {

    @Inject
    lateinit var networkService: ApiFactory

    private lateinit var subscription: Disposable


    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}