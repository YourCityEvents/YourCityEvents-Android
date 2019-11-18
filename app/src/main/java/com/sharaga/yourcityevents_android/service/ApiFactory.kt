package com.sharaga.yourcityevents_android.service

import com.sharaga.yourcityevents_android.service.api.CityApi
import com.sharaga.yourcityevents_android.service.api.EventApi
import com.sharaga.yourcityevents_android.service.api.IdentityApi
import com.sharaga.yourcityevents_android.service.api.UserApi

object ApiFactory {

    val cityApi: CityApi = RetrofitFactory.retrofit()
        .create(CityApi::class.java)

    val evenrApi: EventApi = RetrofitFactory.retrofit()
        .create(EventApi::class.java)

    val identityApi: IdentityApi = RetrofitFactory.retrofit()
        .create(IdentityApi::class.java)

    val userApi: UserApi = RetrofitFactory.retrofit()
        .create(UserApi::class.java)
}