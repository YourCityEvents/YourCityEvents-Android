package com.sharaga.yourcityevents_android.extensions

import android.content.Intent
import androidx.appcompat.app.AlertDialog
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

fun AppCompatActivity.showError(error: String) {
    val builder = AlertDialog.Builder(this)
    builder.setMessage(error)
    builder.setPositiveButton(android.R.string.yes) { _, _ -> }
    builder.show()
}

fun AppCompatActivity.showError(errorList: List<String>?) {
    val builder = AlertDialog.Builder(this)
    val errorMsg : String = errorList!!.joinToString("\n")
    builder.setMessage(errorMsg)
    builder.setPositiveButton(android.R.string.yes) { _, _ -> }
    builder.show()
}
