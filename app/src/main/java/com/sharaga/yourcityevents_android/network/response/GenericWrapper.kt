package com.sharaga.yourcityevents_android.network.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenericWrapper<T>(
    val data: T?,
    val result: Boolean,
    val errors: List<String>?
)
