package com.sharaga.yourcityevents_android.utility

import io.realm.Realm

object UrlConstants {

    val realm: Realm = Realm.getDefaultInstance()
    const val EVENTS_BASE_URL = "https://yourcityevents.azurewebsites.net/api/"
    const val CITY_URL = "City/all"
    const val EVENT_URL = "Event/all"
    const val IDENTITY_URL = "Identity/"
    const val USER_URL = "User/"
}
