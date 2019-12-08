package com.sharaga.yourcityevents_android.network.response.responsedto

import com.sharaga.yourcityevents_android.model.City
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityListResponse(
    val cities: List<City>
)
