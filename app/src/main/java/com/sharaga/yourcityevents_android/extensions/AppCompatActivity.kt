package com.sharaga.yourcityevents_android.extensions

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showError(error: String) {
    val builder = AlertDialog.Builder(this)
    builder.setMessage("$error")
    builder.setPositiveButton(android.R.string.yes) { _, _ -> }
    builder.show()
}