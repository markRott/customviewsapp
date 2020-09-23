package com.example.customviewsapp

import android.content.Context
import android.view.Gravity
import android.widget.Toast

fun Context.showToast(msg: String){
    val toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.show()
}