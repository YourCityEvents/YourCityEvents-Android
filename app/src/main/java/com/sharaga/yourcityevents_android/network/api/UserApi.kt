package com.sharaga.yourcityevents_android.network.api

import com.sharaga.yourcityevents_android.network.response.GenericWrapper
import com.sharaga.yourcityevents_android.network.response.responsedto.UserResponse
import com.sharaga.yourcityevents_android.utility.UrlConstants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {

    @GET(UrlConstants.USER_URL)
    fun getCurrentUserAsync(): Deferred<Response<GenericWrapper<UserResponse>>>
}
