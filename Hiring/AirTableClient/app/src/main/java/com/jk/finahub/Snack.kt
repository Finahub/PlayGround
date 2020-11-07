package com.jk.finahub

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

fun show(v : View, msg: String) {
    val snackBar = Snackbar.make(
        v, msg,
        Snackbar.LENGTH_LONG
    )

    val snackBarView = snackBar.view
    snackBarView.setBackgroundColor(Color.WHITE)
    val textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    textView.setTextColor(Color.parseColor("#4D2593"))
    snackBar.show()
}