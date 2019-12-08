package com.sharaga.yourcityevents_android.network

import com.sharaga.yourcityevents_android.network.api.CityApi
import com.sharaga.yourcityevents_android.network.api.EventApi
import com.sharaga.yourcityevents_android.network.api.IdentityApi
import com.sharaga.yourcityevents_android.network.api.UserApi

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
