package com.sharaga.yourcityevents_android.service.api

import com.sharaga.yourcityevents_android.model.GenericResponse
import com.sharaga.yourcityevents_android.model.entity.City
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CityApi {
    @GET("/cities")
    fun getAllCities(): Deferred<Response<GenericResponse<List<City>>>>
}