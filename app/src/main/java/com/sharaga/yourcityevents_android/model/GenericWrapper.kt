package com.sharaga.yourcityevents_android.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenericWrapper<T>(
    val data: T,
    val result: String,
    val errors: List<String>
)