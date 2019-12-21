package com.sharaga.yourcityevents_android.modules.auth.signup.presenter

import android.os.Bundle
import com.sharaga.yourcityevents_android.extensions.showError
import com.sharaga.yourcityevents_android.extensions.switchToActivity
import com.sharaga.yourcityevents_android.model.City
import com.sharaga.yourcityevents_android.model.User
import com.sharaga.yourcityevents_android.modules.auth.AuthActivity
import com.sharaga.yourcityevents_android.modules.mainbar.MainBarActivity
import com.sharaga.yourcityevents_android.network.ApiFactory
import com.sharaga.yourcityevents_android.security.AppUser
import com.sharaga.yourcityevents_android.utility.KeyConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class Signup3Presenter(private var authActivity: WeakReference<AuthActivity?>) {

    lateinit var getCitiesCallback: (List<String>) -> (Unit)
    private val cityService = ApiFactory.cityApi
    private val identityService = ApiFactory.identityApi
    private lateinit var cities: List<City>

    fun getCities() {
        GlobalScope.launch(Dispatchers.Main) {
            val request = cityService.getAllCitiesAsync()

            try {
                val response = request.await()
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

    fun submitSignup(arguments: Bundle) {
        val creds = AppUser.getCurrentUserCreds()
        val city = cities[arguments.getInt(KeyConstants.CITY_INDEX)]
        val user = User(
            arguments.getString(KeyConstants.FIRST_NAME)!!,
            arguments.getString(KeyConstants.LAST_NAME)!!,
            creds,
            city
        )
        makeRegisterRequest(user)
    }

    private fun makeRegisterRequest(user: User) {
        GlobalScope.launch(Dispatchers.Main) {
            val registerRequest = identityService.registerAsync(user)

            try {
                val response = registerRequest.await()

                if (response.isSuccessful) {
                    if (response.body()!!.result) {
                        AppUser.setCurrentUserCreds(
                            user.email,
                            user.password!!,
                            response.body()?.data!!.token
                        )
                        authActivity.get()?.switchToActivity(MainBarActivity::class.java)
                    } else {
                        authActivity.get()?.showError(response.body()!!.errors)
                    }
                } else {
                    authActivity.get()?.showError("smert' backend or no connection")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
