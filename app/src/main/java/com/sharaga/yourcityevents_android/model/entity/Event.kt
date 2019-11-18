package com.sharaga.yourcityevents_android.model.entity

import com.squareup.moshi.JsonClass
import java.time.LocalDateTime

@JsonClass(generateAdapter = true)
data class Event(
    val id: String,
    val title: String,
    val location: City,
    val description: String,
    val owner: String,
    val date: LocalDateTime,
    val imageUrls: List<String>,
    val links: List<String>,
    val visitors: List<String>,
    val price: Long
)