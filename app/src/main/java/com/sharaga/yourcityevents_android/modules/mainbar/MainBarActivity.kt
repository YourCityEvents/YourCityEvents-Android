package com.sharaga.yourcityevents_android.modules.mainbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.extensions.loadFragment
import com.sharaga.yourcityevents_android.modules.mainbar.create.view.CreateFragment
import com.sharaga.yourcityevents_android.modules.mainbar.feed.view.FeedFragment
import com.sharaga.yourcityevents_android.modules.mainbar.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main_bar.*

class MainBarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_bar)

        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        loadFragment(FeedFragment(), R.id.main_container)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.tab_feed -> {
                loadFragment(FeedFragment(), R.id.main_container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.tab_create -> {
                loadFragment(CreateFragment(), R.id.main_container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.tab_profile -> {
                loadFragment(ProfileFragment(), R.id.main_container)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
