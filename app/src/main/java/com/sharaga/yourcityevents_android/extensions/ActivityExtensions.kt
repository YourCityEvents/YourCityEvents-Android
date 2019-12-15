package com.sharaga.yourcityevents_android.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sharaga.yourcityevents_android.R

fun <T : AppCompatActivity> AppCompatActivity.switchToActivity(clazz: Class<T>) {
    val intent = Intent(this, clazz)
    startActivity(intent)
}

fun AppCompatActivity.loadFragment(fragment: Fragment) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.loginContainer, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}
