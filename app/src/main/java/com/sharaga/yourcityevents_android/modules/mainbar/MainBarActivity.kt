package com.sharaga.yourcityevents_android.modules.mainbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.mainbar.create.CreateFragment
import com.sharaga.yourcityevents_android.modules.mainbar.feed.view.FeedFragment
import com.sharaga.yourcityevents_android.modules.mainbar.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main_bar.*

class MainBarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_bar)
//        val navView: BottomNavigationView = findViewById(R.id.navigationView)

        loadFragment(FeedFragment())
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.tab_feed -> {
                loadFragment(FeedFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.tab_create -> {
                loadFragment(CreateFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.tab_profile -> {
                loadFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}