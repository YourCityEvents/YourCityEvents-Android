package com.sharaga.yourcityevents_android.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Event(
    val id: String,
    val title: String,
    val location: City,
    val description: String,
    val owner: User?,
    val date: String,
    val visitors: List<User>,
    val price: Long
)
