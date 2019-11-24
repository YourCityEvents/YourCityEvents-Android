package com.sharaga.yourcityevents_android.service.api

import com.sharaga.yourcityevents_android.utility.AppConstants
import com.sharaga.yourcityevents_android.model.GenericWrapper
import com.sharaga.yourcityevents_android.model.entity.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IdentityApi {

    @POST(AppConstants.IDENTITY_URL + "register")
    fun register(@Body user: User): Deferred<Response<GenericWrapper<User>>>

    @POST(AppConstants.IDENTITY_URL + "login")
    fun login(): Deferred<Response<GenericWrapper<User>>>
}