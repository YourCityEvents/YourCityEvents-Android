package com.sharaga.yourcityevents_android.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sharaga.yourcityevents_android.security.AppUser
import com.sharaga.yourcityevents_android.utility.UrlConstants
import com.sharaga.yourcityevents_android.utility.NullToEmptyListJsonAdapter
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {

    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .build()


        val newRequest = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer " + AppUser.getCurrentUserCreds().token)
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    val moshi = Moshi
        .Builder()
        .add(NullToEmptyListJsonAdapter.FACTORY)
        .build()!!

    fun retrofit(): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(UrlConstants.EVENTS_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}
