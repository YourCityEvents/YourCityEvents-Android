package com.sharaga.yourcityevents_android.network.api

import com.sharaga.yourcityevents_android.model.User
import com.sharaga.yourcityevents_android.network.response.GenericWrapper
import com.sharaga.yourcityevents_android.security.UserCreds
import com.sharaga.yourcityevents_android.utility.AppConstants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IdentityApi {

    @POST(AppConstants.IDENTITY_URL + "register")
    fun register(@Body user: User): Deferred<Response<GenericWrapper<User>>>

    @POST(AppConstants.IDENTITY_URL + "login")
    fun login(@Body userCreds: UserCreds): Deferred<Response<GenericWrapper<User>>>
}
