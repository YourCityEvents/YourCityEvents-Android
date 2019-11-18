package com.sharaga.yourcityevents_android.model.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val bio: String,
    val email: String,
    val city: City,
    val hostingEvents: List<String>?,
    val visitingEvents: List<String>?,
    val imageUrl: String?,
    val token: String
)