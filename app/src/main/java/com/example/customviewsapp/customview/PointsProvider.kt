package com.example.customviewsapp.customview

import android.graphics.PointF
import com.example.customviewsapp.customview.contracts.PointsProviderContract

object PointsProvider : PointsProviderContract {

    private val points = mutableListOf<PointF>()
    private val connectionPoints1 = mutableListOf<PointF>()
    private val connectionPoints = mutableListOf<PointF>()

    init {
        generateStubPoints()
    }

    private fun generateStubPoints() {
        points.add(PointF(50f, 51f))
        points.add(PointF(139f, 283f))
        points.add(PointF(208f, 201f))
        points.add(PointF(357f, 532f))
        calcConnectionPointsForBezierCurve()
    }

    private fun calcConnectionPointsForBezierCurve() {
        for (i in 1 until points.size) {
            val x = (points[i].x + points[i - 1].x) / 2
            connectionPoints1.add(PointF(x, points[i - 1].y))
            connectionPoints.add(PointF(x, points[i].y))
        }
    }

    override fun points(): List<PointF> = points.toList()

    override fun connectionPoints1(): List<PointF> = connectionPoints1.toList()

    override fun connectionPoints2(): List<PointF> = connectionPoints.toList()
}