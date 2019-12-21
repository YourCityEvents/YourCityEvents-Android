package com.sharaga.yourcityevents_android.modules.mainbar.feed.presenter

import android.os.Handler
import com.sharaga.yourcityevents_android.model.Event
import com.sharaga.yourcityevents_android.modules.mainbar.feed.view.FeedFragment
import com.sharaga.yourcityevents_android.network.ApiFactory
import com.sharaga.yourcityevents_android.repository.EventRepository
import com.sharaga.yourcityevents_android.repository.realmdto.RealmEvent
import io.realm.RealmResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class FeedPresenter(private var view: WeakReference<FeedFragment>) {

    lateinit var updateEventsCallback: (RealmResults<RealmEvent>) -> (Unit)
    private val eventRep = EventRepository()
    private val eventService = ApiFactory.evenrApi
    private lateinit var events : List<Event>

    fun displayEvents() {
        showEventsFromRep()
        eventRep.deleteAll()
        getEventsFromApi()
        Handler().postDelayed({
            eventRep.saveAll(events.map { RealmEvent(it) })
            showEventsFromRep()
        }, 2500)

    }

    private fun showEventsFromRep() {
        updateEventsCallback(eventRep.getAll())
    }

    private fun getEventsFromApi() {
        GlobalScope.launch(Dispatchers.Default) {
            val request = eventService.getAllEventsAsync()

            try {
                val response = request.await()
                if (response.isSuccessful) {
                    events = response.body()?.data?.events!!
                } else {
                    //todo add popup exception
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
