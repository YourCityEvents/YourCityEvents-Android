package com.sharaga.yourcityevents_android.repository

import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.Sort

abstract class BaseRepository<T : RealmObject>(private val ofType: Class<T>, private val realm: Realm = Realm.getDefaultInstance()) {

    fun getById(id: String): T? {
        return realm.where(ofType).equalTo("id", id).findFirst()
    }

    fun save(entity: T) {
        realm.executeTransaction {
            it.copyToRealmOrUpdate(entity)
        }
    }

    fun saveAll(list: List<T>) {
        realm.executeTransaction { realm ->
            list.forEach {
                realm.copyToRealmOrUpdate(it)
            }
        }
    }

    fun deleteAll() {
        realm.executeTransaction {
            it.deleteAll()
        }
    }

    fun deleteAllWithType() {
        realm.executeTransaction{
            it.delete(ofType)
        }
    }

    fun getAll(): RealmResults<T> {
        return realm.where(ofType).sort("id", Sort.ASCENDING).findAll()
    }
}
