package com.sharaga.yourcityevents_android.security

import com.jcloquell.androidsecurestorage.SecureStorage
import com.sharaga.yourcityevents_android.utility.MainApplication

object SecretStorage {

    private val secureStorage = SecureStorage(MainApplication.applicationContext())

    fun getVal(key: String): String {
        return secureStorage.getObject(key, String::class.java) ?: ""
    }

    fun setVal(key: String, value: String) {
        secureStorage.storeObject(key, value)
    }

    fun removeVal(key: String) {
        secureStorage.removeObject(key)
    }
}
