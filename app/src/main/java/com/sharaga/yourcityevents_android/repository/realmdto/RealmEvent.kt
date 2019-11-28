package com.sharaga.yourcityevents_android.repository.realmdto

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.time.LocalDateTime

open class RealmEvent(
    @PrimaryKey
    val id: String,
    val title: String,
    val location: String,
    val description: String,
    val owner: RealmUser,
    val date: LocalDateTime,
    val imageUrls: List<String>,
    val links: List<String>,
    val visitors: RealmList<RealmUser>,
    val price: Long
) : RealmObject()