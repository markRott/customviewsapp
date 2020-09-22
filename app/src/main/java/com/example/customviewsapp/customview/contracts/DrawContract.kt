package com.example.customviewsapp.customview.contracts

import android.content.res.TypedArray
import android.graphics.Canvas

interface DrawContract {

    fun onDraw(canvas: Canvas)

    fun setupTypedArray(typedArray: TypedArray)
}