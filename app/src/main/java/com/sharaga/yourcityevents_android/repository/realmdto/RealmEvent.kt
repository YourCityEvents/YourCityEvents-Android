package com.sharaga.yourcityevents_android.repository.realmdto

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmEvent(
    @PrimaryKey
    var id: String? = null,
    var title: String? = null,
    var location: String? = null,
    var description: String? = null,
    var owner: RealmUser? = null,
    var date: String? = null,
    var imageUrls: RealmList<String>? = null,
    var links: RealmList<String>? = null,
    var visitors: RealmList<RealmUser>? = null,
    var price: Long? = null
) : RealmObject()