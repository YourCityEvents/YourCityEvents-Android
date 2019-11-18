package com.sharaga.yourcityevents_android.security

data class UserCreds(
    val login: String,
    val password: String,
    val token: String
)


object AppUser {

    val current: UserCreds = getCurrentUserCreds()

    private fun getCurrentUserCreds(): UserCreds {
        return UserCreds(
            SecureStorage.getVal("login"),
            SecureStorage.getVal("password"),
            SecureStorage.getVal("token")
        )
    }

    fun signOut() {
        SecureStorage.clear()
    }

    fun setCurrentUserCreds(login: String, password: String, token: String) {
        SecureStorage.setVal("login", login)
        SecureStorage.setVal("password", password)
        SecureStorage.setVal("token", token)
    }
}