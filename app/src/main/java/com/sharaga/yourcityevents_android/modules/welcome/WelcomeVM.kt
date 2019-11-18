package com.sharaga.yourcityevents_android.modules.welcome

import com.sharaga.yourcityevents_android.base.BaseViewModel
import com.sharaga.yourcityevents_android.service.ApiFactory
import com.sharaga.yourcityevents_android.service.api.CityApi
import dagger.Module
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

@Module
class WelcomeVM: BaseViewModel() {

    lateinit var networkService: CityApi

    val clickSubject = PublishSubject.create<Int>()

    private lateinit var subscription: Disposable

    init {

        clickSubject.subscribe { emitter ->
            print(emitter)
            print("yolo")
        }

    }


    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}