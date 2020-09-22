package com.example.customviewsapp.customview.contracts

import android.graphics.PointF

interface PointsProviderContract {

    fun points() : List<PointF>

    fun connectionPoints1() : List<PointF>

    fun connectionPoints2() : List<PointF>
}