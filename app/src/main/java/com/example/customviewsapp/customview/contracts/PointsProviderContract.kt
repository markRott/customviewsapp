package com.example.customviewsapp.customview.contracts

import android.graphics.PointF
import com.example.customviewsapp.customview.PointClickData

interface PointsProviderContract {

    fun points() : List<PointF>

    fun connectionPoints1() : List<PointF>

    fun connectionPoints2() : List<PointF>

    fun savePointClickData(data: PointClickData)

    fun pointsClickData() : List<PointClickData>
}