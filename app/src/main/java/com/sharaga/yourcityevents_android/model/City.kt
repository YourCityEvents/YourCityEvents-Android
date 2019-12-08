package com.sharaga.yourcityevents_android.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class City(
    val id: String,
    val nameUa: String,
    val nameEn: String
)
