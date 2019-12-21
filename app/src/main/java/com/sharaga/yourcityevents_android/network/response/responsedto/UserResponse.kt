package com.sharaga.yourcityevents_android.network.response.responsedto

import com.sharaga.yourcityevents_android.model.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    val user: User
)
