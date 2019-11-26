package com.sharaga.yourcityevents_android.extensions

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

fun Fragment.showError(error: String) {
    val act = activity?:return
    val builder = AlertDialog.Builder(act)
    builder.setMessage("$error")
    builder.setPositiveButton(android.R.string.yes) { _, _ -> }
    builder.show()
}

fun Fragment.show(message: String) {
//    val builder = AlertDialog.Builder(activity!!.applicationContext)
//    builder.setMessage("$message")
//    builder.setPositiveButton(android.R.string.yes) { _, _ -> }
//    builder.show()
}