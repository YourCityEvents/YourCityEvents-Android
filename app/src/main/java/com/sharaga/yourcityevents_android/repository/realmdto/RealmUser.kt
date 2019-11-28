package com.sharaga.yourcityevents_android.repository.realmdto

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmUser(
    @PrimaryKey
    val id: String,
    val firstName: String,
    val lastName: String,
    val bio: String,
    val email: String,
    val city: String,
    val hostingEvents: RealmList<RealmEvent>,
    val visitingEvents: RealmList<RealmEvent>,
    val imageUrl: String?,
    val token: String
) : RealmObject()