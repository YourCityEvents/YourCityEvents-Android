package com.sharaga.yourcityevents_android.modules.mainbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.sharaga.yourcityevents_android.R
import com.sharaga.yourcityevents_android.modules.create.CreateFragment
import com.sharaga.yourcityevents_android.modules.feed.FeedFragment
import com.sharaga.yourcityevents_android.modules.profile.ProfileFragment

class MainBarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_bar_activity)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.tab_feed -> {
                loadFragment(FeedFragment())
                true
            }
            R.id.tab_create -> {
                loadFragment(CreateFragment())
                true
            }
            R.id.tab_profile -> {
                loadFragment(ProfileFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}