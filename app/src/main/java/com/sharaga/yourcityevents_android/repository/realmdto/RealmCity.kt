package com.sharaga.yourcityevents_android.repository.realmdto

import com.sharaga.yourcityevents_android.model.City
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmCity(
    @PrimaryKey
    var id: String? = null,
    var nameUa: String? = null,
    var nameEn: String? = null
) : RealmObject() {

    constructor(city: City) : this(
        city.id,
        city.nameUa,
        city.nameEn
    )
}
