package com.sharaga.yourcityevents_android.repository

import com.sharaga.yourcityevents_android.repository.realmdto.RealmEvent

class EventRepository(ofType: Class<RealmEvent> = RealmEvent::class.java) :
    BaseRepository<RealmEvent>(ofType)
