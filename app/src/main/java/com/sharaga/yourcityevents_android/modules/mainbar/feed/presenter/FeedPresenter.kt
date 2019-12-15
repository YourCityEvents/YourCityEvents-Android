package com.sharaga.yourcityevents_android.modules.mainbar.feed.presenter

import com.sharaga.yourcityevents_android.modules.mainbar.feed.view.FeedFragment
import com.sharaga.yourcityevents_android.network.ApiFactory
import com.sharaga.yourcityevents_android.repository.EventRepository
import com.sharaga.yourcityevents_android.repository.realmdto.RealmEvent
import com.sharaga.yourcityevents_android.validators.EmailValidator
import com.sharaga.yourcityevents_android.validators.PasswordValidator
import io.realm.RealmResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class FeedPresenter(private var view: WeakReference<FeedFragment>) {

    lateinit var updateEventsCallback: (RealmResults<RealmEvent>) -> (Unit)

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()
    private val identityApi = ApiFactory.identityApi
    private val eventRep = EventRepository()
    private val eventService = ApiFactory.evenrApi

    fun displayEvents() {

        var events = eventRep.getAll()

        updateEventsCallback(events)

        eventRep.deleteAll()

        getEventsFromApi()

//        AppUser.setCurrentUserCreds("yarykloh2@example.com", "string", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ5YXJ5a2xvaDJAZXhhbXBsZS5jb20iLCJqdGkiOiI0MDExNThiYS1hMDQwLTRjMzctYmYyMS01OWIyMTcxZmUxZGMiLCJlbWFpbCI6InlhcnlrbG9oMkBleGFtcGxlLmNvbSIsIm5iZiI6MTU3NjM1MTg1NCwiZXhwIjoxNTc2MzU5MDU0LCJpYXQiOjE1NzYzNTE4NTR9.OP6CbJyFqhkSc_nfAiYRDDGoi2UuBgUDyZMiLkpfjEg")
    }

    private fun getEventsFromApi() {
        GlobalScope.launch(Dispatchers.Default) {
            val request = eventService.getAllEventsAsync()

            try {
                val response = request.await()
                if (response.isSuccessful) {
                    val events = response.body()?.data?.events

                    eventRep.saveAll(events!!.map { RealmEvent(it) })
                    updateEventsCallback(eventRep.getAll())
                } else {
                    println("chisto byl proeb")
                    //todo add popup exception
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
