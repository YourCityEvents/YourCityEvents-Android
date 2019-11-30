package com.sharaga.yourcityevents_android.repository.realmdto

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmUser(
    @PrimaryKey
    var id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var bio: String? = null,
    var email: String? = null,
    var city: String? = null,
    var hostingEvents: RealmList<RealmEvent>? = null,
    var visitingEvents: RealmList<RealmEvent>? = null,
    var imageUrl: String? = null,
    var token: String? = null
) : RealmObject()