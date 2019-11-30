package com.sharaga.yourcityevents_android.repository

import com.sharaga.yourcityevents_android.repository.realmdto.RealmEvent
import io.realm.Realm

class EventRepository(realm: Realm = Realm.getDefaultInstance(), ofType: Class<RealmEvent> = RealmEvent::class.java) :
    BaseRepository<RealmEvent>(realm, ofType)