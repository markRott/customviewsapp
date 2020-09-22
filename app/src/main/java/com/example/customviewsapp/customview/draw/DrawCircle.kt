package com.example.customviewsapp.customview.draw

import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.customviewsapp.R
import com.example.customviewsapp.customview.contracts.DrawContract
import com.example.customviewsapp.customview.contracts.PointsProviderContract

class DrawCircle(private val pointsProvider: PointsProviderContract) : DrawContract {

    private var radius = 13f
    private var circleColor = Color.RED

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = circleColor
    }

    override fun onDraw(canvas: Canvas) {
        pointsProvider.points().forEach {
            canvas.drawCircle(it.x, it.y, radius, circlePaint)
        }
    }

    override fun setupTypedArray(typedArray: TypedArray) {
        circleColor = typedArray.getColor(R.styleable.LineView_circle_color, Color.RED)
        radius = typedArray.getFloat(R.styleable.LineView_circle_radius, 13f)

        circlePaint.color = circleColor
    }
}