package com.sharaga.yourcityevents_android.modules.welcome

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
<<<<<<< HEAD:app/src/main/java/com/sharaga/yourcityevents_android/MainActivity.kt
import com.sharaga.yourcityevents_android.model.entity.City
import com.sharaga.yourcityevents_android.model.entity.User
import com.sharaga.yourcityevents_android.R
>>>>>>> 83ff1ee75c42993dc7580c33d83aaa855a4ba3a7:app/src/main/java/com/sharaga/yourcityevents_android/modules/welcome/WelcomeActivity.kt
import com.sharaga.yourcityevents_android.service.ApiFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {

    private lateinit var viewModel: WelcomeVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val cityService = ApiFactory.cityApi
        val identityService = ApiFactory.identityApi
        val eventService = ApiFactory.evenrApi
        val userService = ApiFactory.userApi

        GlobalScope.launch(Dispatchers.Default) {
            val regRequest = identityService.register(User("","first name", "last name", "bio", "email@hi.girls", City(  "5dcfdf731822562bacb524c1",
                 "string",
                "string"), null, null, null, ""))

            try {
                val response = regRequest.await()
                if (response.isSuccessful) {
                    val user = response.body()
                    print(user)
                } else {
                    Log.d("MainActivity ", response.errorBody().toString())
                }

            } catch (e: Exception) {

            }
        }

        GlobalScope.launch(Dispatchers.Default) {
            val cityRequest = cityService.getAllCities()
            val postRequest = identityService.register(User("","first name", "last name", "bio", "email@hi.girls", City(  "5dcfdf731822562bacb524c1",
                "string",
                "string"), null, null, null, ""))

            try {
                val response = cityRequest.await()
                if (response.isSuccessful) {
                    val user = response.body()
                    print(user)
                } else {
                    Log.d("MainActivity ", response.errorBody().toString())
                }

            } catch (e: Exception) {

            }
        }


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
