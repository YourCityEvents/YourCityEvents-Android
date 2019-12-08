package com.sharaga.yourcityevents_android.network.api

import com.sharaga.yourcityevents_android.network.response.GenericWrapper
import com.sharaga.yourcityevents_android.network.response.responsedto.EventListResponse
import com.sharaga.yourcityevents_android.utility.AppConstants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface EventApi {
    @GET(AppConstants.EVENT_URL)
    fun getAllEventsAsync(): Deferred<Response<GenericWrapper<EventListResponse>>>

}
