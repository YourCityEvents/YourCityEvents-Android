package com.sharaga.yourcityevents_android.network.api

import com.sharaga.yourcityevents_android.model.User
import com.sharaga.yourcityevents_android.network.response.GenericWrapper
import com.sharaga.yourcityevents_android.network.response.responsedto.AuthResponse
import com.sharaga.yourcityevents_android.security.UserCreds
import com.sharaga.yourcityevents_android.utility.UrlConstants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IdentityApi {

    @POST(UrlConstants.IDENTITY_URL + "register")
    fun registerAsync(@Body user: User): Deferred<Response<GenericWrapper<AuthResponse>>>

    @POST(UrlConstants.IDENTITY_URL + "login")
    fun loginAsync(@Body userCreds: UserCreds): Deferred<Response<GenericWrapper<AuthResponse>>>
}
