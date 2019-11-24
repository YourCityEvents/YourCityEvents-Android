package com.sharaga.yourcityevents_android.service.api

import com.sharaga.yourcityevents_android.utility.AppConstants
import com.sharaga.yourcityevents_android.model.GenericWrapper
import com.sharaga.yourcityevents_android.model.entity.CityResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CityApi {

    @GET(AppConstants.CITY_URL)
    fun getAllCitiesAsync(): Deferred<Response<GenericWrapper<CityResponse>>>
}