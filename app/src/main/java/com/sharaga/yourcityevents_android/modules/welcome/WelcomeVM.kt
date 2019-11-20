package com.sharaga.yourcityevents_android.modules.welcome

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sharaga.yourcityevents_android.base.BaseViewModel
import com.sharaga.yourcityevents_android.service.ApiFactory
import dagger.Module
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Module
class WelcomeVM: BaseViewModel() {

    val cityService = ApiFactory.cityApi
    private val newText = MutableLiveData<String>()

    val clickSubject = PublishSubject.create<Int>()
    private lateinit var subscription: Disposable

    init {

        GlobalScope.launch(Dispatchers.Default) {
            val postRequest = cityService.getAllCities()

            try {
                val response = postRequest.await()
                if (response.isSuccessful) {
                    val posts = response.body()
                    println(posts?.data)
                } else {
                    Log.d("MainActivity ", response.errorBody().toString())
                }

            } catch (e: Exception) {

            }
        }

        clickSubject.subscribe { emitter ->
            newText.value = "yes boss"
            getUsername()
            println(emitter)
            println("yolo")
        }.dispose()

    }

    fun getUsername(): LiveData<String> {
        return newText
    }


    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}