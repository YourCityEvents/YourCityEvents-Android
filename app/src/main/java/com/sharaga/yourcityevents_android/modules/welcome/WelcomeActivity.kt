package com.sharaga.yourcityevents_android.modules.welcome

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.base.ViewModelInjector
import com.sharaga.yourcityevents_android.service.ApiFactory
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.notify

class WelcomeActivity : AppCompatActivity() {

    private lateinit var viewModel: WelcomeVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = WelcomeVM()
        val cityService = ApiFactory.cityApi

        GlobalScope.launch(Dispatchers.Default) {
            val postRequest = cityService.getAllCities()

            try {
                val response = postRequest.await()
                if (response.isSuccessful) {
                    val posts = response.body()
                    print(posts)
                } else {
                    Log.d("MainActivity ", response.errorBody().toString())
                }

            } catch (e: Exception) {

            }
        }


        fab.setOnClickListener { view ->
            viewModel.clickSubject.onNext(1)
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
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
