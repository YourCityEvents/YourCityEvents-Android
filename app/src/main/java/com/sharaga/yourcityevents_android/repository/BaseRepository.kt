package com.sharaga.yourcityevents_android.repository

import io.realm.Realm
import io.realm.RealmObject

abstract class BaseRepository<T : RealmObject>(
    private val realm: Realm,
    private val ofType: Class<T>
) {





}
