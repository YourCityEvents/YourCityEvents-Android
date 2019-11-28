package com.sharaga.yourcityevents_android.repository

import com.sharaga.yourcityevents_android.model.entity.User

class UserRepository : BaseRepository() {
    fun saveUser(user: User) {
        realm.beginTransaction()
        realm.insert(user)
        realm.commitTransaction()
    }
}