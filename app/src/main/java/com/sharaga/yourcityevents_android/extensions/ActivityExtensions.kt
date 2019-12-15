package com.sharaga.yourcityevents_android.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun <T : AppCompatActivity> AppCompatActivity.switchToActivity(clazz: Class<T>) {
    val intent = Intent(this, clazz)
    startActivity(intent)
}

fun AppCompatActivity.loadFragment(fragment: Fragment, containerId: Int) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(containerId, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}
