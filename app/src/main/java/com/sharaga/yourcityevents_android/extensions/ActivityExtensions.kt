package com.sharaga.yourcityevents_android.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun <T : AppCompatActivity> AppCompatActivity.switchToActivity(clazz: Class<T>) {
    val intent = Intent(this, clazz)
    startActivity(intent)
}