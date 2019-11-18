package com.sharaga.yourcityevents_android.modules.welcome

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.sharaga.yourcityevents_android.R
>>>>>>> 83ff1ee75c42993dc7580c33d83aaa855a4ba3a7:app/src/main/java/com/sharaga/yourcityevents_android/modules/welcome/WelcomeActivity.kt
import com.sharaga.yourcityevents_android.service.ApiFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class WelcomeActivity : AppCompatActivity() {

    private lateinit var viewModel: WelcomeVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(WelcomeVM::class.java)

        viewModel.getUsername().observe(this, Observer {emitter ->
            textView.text = emitter
        })
        textView.text = "Yes"

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
