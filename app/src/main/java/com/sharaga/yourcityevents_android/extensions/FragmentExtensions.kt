package com.sharaga.yourcityevents_android.extensions

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import io.realm.RealmList

fun Fragment.showError(error: String) {
    val act = activity ?: return
    val builder = AlertDialog.Builder(act)
    builder.setMessage("$error")
    builder.setPositiveButton(android.R.string.yes) { _, _ -> }
    builder.show()
}

fun <T> RealmList<T>.toList() : MutableList<T> {
    return this
}

fun Fragment.show(message: String) {
//    val builder = AlertDialog.Builder(activity!!.applicationContext)
//    builder.setMessage("$message")
//    builder.setPositiveButton(android.R.string.yes) { _, _ -> }
//    builder.show()
}
