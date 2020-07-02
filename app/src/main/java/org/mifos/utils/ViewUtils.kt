package org.mifos.utils

import android.content.Context
import android.view.View
import android.widget.Toast

/**
 * Created by grandolf49 on 17-06-2020
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}