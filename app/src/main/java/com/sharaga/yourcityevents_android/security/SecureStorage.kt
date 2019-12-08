package com.sharaga.yourcityevents_android.security

import com.sharaga.yourcityevents_android.utility.MainApplication
import de.adorsys.android.securestoragelibrary.SecurePreferences

object SecureStorage {

    fun getVal(key: String): String {
        return SecurePreferences.getStringValue(MainApplication.applicationContext(), key, "") ?: ""
    }

    fun setVal(key: String, value: String) {
        SecurePreferences.setValue(MainApplication.applicationContext(), key, value)
    }

    fun removeVal(key: String) {
        SecurePreferences.removeValue(MainApplication.applicationContext(), key)
    }

    fun clear() {
        SecurePreferences.clearAllValues(MainApplication.applicationContext())
    }
}
