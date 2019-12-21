package com.sharaga.yourcityevents_android.repository.realmdto

import com.sharaga.yourcityevents_android.model.Event
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmEvent(
    @PrimaryKey
    var id: String? = null,
    var title: String? = null,
    var location: RealmCity? = null,
    var description: String? = null,
    var owner: RealmUser? = null,
    var date: String? = null,
    var visitors: RealmList<RealmUser>? = null,
    var price: Long? = null
) : RealmObject() {

    constructor(event: Event) : this(
        event.id,
        event.title,
        RealmCity(event.location),
        event.description,
        RealmUser(event.owner),
        event.date,
        event.visitors.map { RealmUser(it) }.toCollection(RealmList<RealmUser>()),
        event.price
    )
}
