package com.sharaga.yourcityevents_android.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val bio: String? = null,
    val email: String,
    val city: City,
    val hostingEvents: List<Event>,
    val visitingEvents: List<Event>,
    val imageUrl: String?,
    val token: String
)
