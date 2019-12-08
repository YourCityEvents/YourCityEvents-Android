package com.sharaga.yourcityevents_android.modules.mainbar.feed.presenter

import com.sharaga.yourcityevents_android.modules.mainbar.feed.view.FeedFragment
import com.sharaga.yourcityevents_android.network.ApiFactory
import com.sharaga.yourcityevents_android.network.validators.EmailValidator
import com.sharaga.yourcityevents_android.network.validators.PasswordValidator
import com.sharaga.yourcityevents_android.repository.EventRepository
import com.sharaga.yourcityevents_android.repository.realmdto.RealmCity
import com.sharaga.yourcityevents_android.repository.realmdto.RealmEvent
import com.sharaga.yourcityevents_android.repository.realmdto.RealmUser
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import java.util.*


class FeedPresenter(private var view: WeakReference<FeedFragment>) {

    lateinit var updateEventsCallback: (RealmResults<RealmEvent>) -> (Unit)

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()
    private val identityApi = ApiFactory.identityApi
    private val eventRep = EventRepository(Realm.getDefaultInstance())
    private val eventService = ApiFactory.evenrApi

    fun displayEvents() {

        var events = eventRep.getAll()

        updateEventsCallback(events)

        eventRep.deleteAll()

        GlobalScope.launch(Dispatchers.Default) {
            val request = eventService.getAllEventsAsync()

            try {
                val response = request.await()
                if (response.isSuccessful) {
                    val events = response.body()?.data?.events

                    eventRep.saveAll(events)
                    updateEventsCallback(response.body())
                } else {
                    //todo add popup exception
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

//        eventRep.save(
//            RealmEvent(
//                "id", "title 1",
//                RealmCity("", "Kyiv", "Kyiv"), "desc",
//                RealmUser(
//                    "id", "name", "last", "bio", "email",
//                    RealmCity("", "Kyiv", "Kyiv"), RealmList(), RealmList(), null, "token"
//                ),
//                Date(), RealmList(), RealmList(), RealmList(), 1488L
//            )
//        )
    }
}
