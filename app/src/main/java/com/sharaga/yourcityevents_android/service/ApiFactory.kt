package com.sharaga.yourcityevents_android.service

import com.sharaga.yourcityevents_android.service.api.CityApi

object ApiFactory {

    val cityApi: CityApi = RetrofitFactory.retrofit()
        .create(CityApi::class.java)
}