package com.sharaga.yourcityevents_android.network.response.responsedto

import com.sharaga.yourcityevents_android.model.Event
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventListResponse(
    val events: List<Event>
)
