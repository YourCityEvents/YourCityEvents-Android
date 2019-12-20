package com.sharaga.yourcityevents_android.network.response.responsedto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthResponse(
    val token: String
)
