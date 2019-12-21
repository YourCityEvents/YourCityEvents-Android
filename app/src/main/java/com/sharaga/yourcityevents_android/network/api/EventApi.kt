package com.sharaga.yourcityevents_android.network.api

import com.sharaga.yourcityevents_android.model.Event
import com.sharaga.yourcityevents_android.network.response.GenericWrapper
import com.sharaga.yourcityevents_android.network.response.responsedto.EventListResponse
import com.sharaga.yourcityevents_android.network.response.responsedto.EventResponse
import com.sharaga.yourcityevents_android.utility.UrlConstants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EventApi {

    @GET(UrlConstants.EVENT_URL)
    fun getAllEventsAsync(): Deferred<Response<GenericWrapper<EventListResponse>>>

    @POST(UrlConstants.EVENT_URL)
    fun postEventAsync(@Body event: Event): Deferred<Response<GenericWrapper<EventResponse>>>
}
