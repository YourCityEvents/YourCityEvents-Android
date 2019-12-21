package com.sharaga.yourcityevents_android.modules.mainbar.create.presenter

import android.os.Bundle
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.extensions.loadFragment
import com.sharaga.yourcityevents_android.extensions.showError
import com.sharaga.yourcityevents_android.model.City
import com.sharaga.yourcityevents_android.model.Event
import com.sharaga.yourcityevents_android.model.User
import com.sharaga.yourcityevents_android.modules.mainbar.MainBarActivity
import com.sharaga.yourcityevents_android.modules.mainbar.feed.view.FeedFragment
import com.sharaga.yourcityevents_android.network.ApiFactory
import com.sharaga.yourcityevents_android.utility.KeyConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class CreatePresenter(private var mainBarActivity: WeakReference<MainBarActivity?>) {

    lateinit var getCitiesCallback: (List<String>) -> (Unit)
    private val cityService = ApiFactory.cityApi
    private val eventService = ApiFactory.evenrApi
    private val userService = ApiFactory.userApi
    private lateinit var cities: List<City>
    private lateinit var currentUser: User

    fun getCities() {
        GlobalScope.launch(Dispatchers.Main) {
            val cityRequest = cityService.getAllCitiesAsync()

            try {
                val response = cityRequest.await()
                if (response.isSuccessful) {
                    cities = response.body()?.data?.cities!!

                    getCitiesCallback(cities.map { v -> v.nameEn })
                } else {
                    //todo add popup exception
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getCurrentUser() {
        GlobalScope.launch(Dispatchers.Main) {
            val cityRequest = userService.getCurrentUserAsync()

            try {
                val response = cityRequest.await()
                if (response.isSuccessful) {
                    currentUser = response.body()?.data?.user!!
                } else {
                    //todo add popup exception
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun createEvent(arguments: Bundle) {

        if (arguments.getString(KeyConstants.EVENT_NAME)!!.isNotBlank() &&
            arguments.getString(KeyConstants.EVENT_DESC)!!.isNotBlank() &&
            arguments.getString(KeyConstants.EVENT_DATE)!!.isNotBlank()
        ) {

            createEventRequest(
                Event(
                    "",
                    arguments.getString(KeyConstants.EVENT_NAME).toString(),
                    cities[arguments.getInt(KeyConstants.CITY_INDEX)],
                    arguments.getString(KeyConstants.EVENT_DESC).toString(),
                    currentUser,
                    arguments.getString(KeyConstants.EVENT_DATE).toString(),
                    emptyList(),
                    arguments.getString(KeyConstants.EVENT_PRICE).toString().toLong()
                )
            )



            mainBarActivity.get()?.loadFragment(FeedFragment(), R.id.main_container)
        } else {
            mainBarActivity.get()?.showError("name and surname shouldnt be blank")
        }

    }

    private fun createEventRequest(event: Event) {
        GlobalScope.launch(Dispatchers.Main) {
            val registerRequest = eventService.postEventAsync(event)

            try {
                val response = registerRequest.await()

                if (response.isSuccessful) {
                    if (response.body()!!.result) {

                        mainBarActivity.get()?.loadFragment(FeedFragment(), R.id.main_container)
                    } else {
                        mainBarActivity.get()?.showError(response.body()!!.errors)
                    }
                } else {
                    mainBarActivity.get()?.showError("smert' backend or no connection")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
