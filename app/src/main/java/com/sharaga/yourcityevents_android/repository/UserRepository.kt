package com.sharaga.yourcityevents_android.repository

import com.sharaga.yourcityevents_android.repository.realmdto.RealmUser

class UserRepository(ofType: Class<RealmUser> = RealmUser::class.java) :
    BaseRepository<RealmUser>(ofType)
