package com.sharaga.yourcityevents_android.repository.realmdto

import com.sharaga.yourcityevents_android.model.User
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
    var city: RealmCity? = null,
    var hostingEvents: RealmList<RealmEvent>? = null,
    var visitingEvents: RealmList<RealmEvent>? = null,
    var imageUrl: String? = null,
    var token: String? = null
) : RealmObject() {

    constructor(user: User?) : this(
        user?.id,
        user?.firstName,
        user?.lastName,
        user?.bio,
        user?.email,
        RealmCity(user?.city),
        user?.hostingEvents?.map {
            RealmEvent(it)
        }?.toCollection(RealmList<RealmEvent>()),
        user?.visitingEvents?.map {
            RealmEvent(it)
        }?.toCollection(RealmList<RealmEvent>()),
        user?.imageUrl,
        user?.token
    )
}
