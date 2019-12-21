package com.sharaga.yourcityevents_android.network.api

import com.sharaga.yourcityevents_android.network.response.GenericWrapper
import com.sharaga.yourcityevents_android.network.response.responsedto.CityListResponse
import com.sharaga.yourcityevents_android.utility.UrlConstants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CityApi {

    @GET(UrlConstants.CITY_URL)
    fun getAllCitiesAsync(): Deferred<Response<GenericWrapper<CityListResponse>>>
}
