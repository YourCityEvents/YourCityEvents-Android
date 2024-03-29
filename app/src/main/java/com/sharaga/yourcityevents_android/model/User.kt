package com.sharaga.yourcityevents_android.model

import com.sharaga.yourcityevents_android.security.UserCreds
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val bio: String? = null,
    val email: String,
    val password: String? = null,
    val city: City,
    val hostingEvents: List<Event>,
    val visitingEvents: List<Event>,
    val imageUrl: String?,
    val token: String?
) {
    constructor(firstName: String, lastName: String, creds: UserCreds, city: City) : this(
        "",
        firstName,
        lastName,
        "",
        creds.login,
        creds.password,
        city,
        emptyList<Event>(),
        emptyList<Event>(),
        null,
        null
    )
}
