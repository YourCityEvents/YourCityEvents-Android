package com.sharaga.yourcityevents_android.security

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class UserCreds(
    @Json(name = "email")
    val login: String,
    val password: String,
    val token: String
) {
    constructor(login: String, password: String) : this(
        login,
        password,
        ""
    )
}

object AppUser {

    fun getCurrentUserCreds(): UserCreds {
        return UserCreds(
            SecretStorage.getVal("login"),
            SecretStorage.getVal("password"),
            SecretStorage.getVal("token")
        )
    }

    fun signOut() {
        SecretStorage.removeVal("login")
        SecretStorage.removeVal("password")
        SecretStorage.removeVal("token")
    }

    fun setCurrentUserCreds(login: String, password: String, token: String) {
        SecretStorage.setVal("login", login)
        SecretStorage.setVal("password", password)
        SecretStorage.setVal("token", token)
    }

    fun setCurrentUserCreds(login: String, password: String) {
        SecretStorage.setVal("login", login)
        SecretStorage.setVal("password", password)
    }
}
