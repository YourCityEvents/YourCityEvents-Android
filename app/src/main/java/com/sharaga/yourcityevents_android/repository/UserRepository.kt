package com.sharaga.yourcityevents_android.repository

import com.sharaga.yourcityevents_android.repository.realmdto.RealmUser
import io.realm.Realm

class UserRepository(realm: Realm = Realm.getDefaultInstance(), ofType: Class<RealmUser> = RealmUser::class.java) :
    BaseRepository<RealmUser>(realm, ofType)