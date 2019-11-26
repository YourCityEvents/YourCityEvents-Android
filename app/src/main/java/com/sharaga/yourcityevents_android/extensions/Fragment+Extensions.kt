package com.sharaga.yourcityevents_android.extensions

import android.app.Activity
import androidx.appcompat.app.AlertDialog

fun Activity.showError(error: String) {
    val builder = AlertDialog.Builder(this)
    builder.setMessage("$error")
    builder.setPositiveButton(android.R.string.yes) { _, _ -> }
    builder.show()
}

fun Activity.show(message: String) {
    val builder = AlertDialog.Builder(this)
    builder.setMessage("$message")
    builder.setPositiveButton(android.R.string.yes) { _, _ -> }
    builder.show()
}