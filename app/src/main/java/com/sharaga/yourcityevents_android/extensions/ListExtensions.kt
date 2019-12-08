package com.sharaga.yourcityevents_android.extensions

import io.realm.RealmList


fun <T> List<T>.convertToRealmList() : RealmList<T> {
    return this.toCollection(RealmList())
}
