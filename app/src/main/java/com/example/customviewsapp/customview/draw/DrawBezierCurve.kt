package com.example.customviewsapp.customview.draw

import android.content.res.TypedArray
import android.graphics.*
import com.example.customviewsapp.R
import com.example.customviewsapp.customview.contracts.DrawContract
import com.example.customviewsapp.customview.contracts.PointsProviderContract

class DrawBezierCurve(private val pointsProvider: PointsProviderContract) : DrawContract {

    private var lineWidth = 8f
    private var lineColor = Color.RED

    private val bezierCurvePath = Path()
    private val bezierCurvePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = lineWidth
        color = lineColor
    }

    override fun setupTypedArray(typedArray: TypedArray) {
        lineColor = typedArray.getColor(R.styleable.LineView_line_color, Color.RED)
        lineWidth = typedArray.getFloat(R.styleable.LineView_line_width, 8f)

        bezierCurvePaint.color = lineColor
        bezierCurvePaint.strokeWidth = lineWidth
    }

    override fun onDraw(canvas: Canvas) {
        bezierCurvePath.reset()
        bezierCurvePath.moveTo(pointsProvider.points().first().x, pointsProvider.points().first().y)

        for (i in 1 until pointsProvider.points().size) {

            bezierCurvePath.cubicTo(
                pointsProvider.connectionPoints1()[i - 1].x,
                pointsProvider.connectionPoints1()[i - 1].y,
                pointsProvider.connectionPoints2()[i - 1].x,
                pointsProvider.connectionPoints2()[i - 1].y,
                pointsProvider.points()[i].x,
                pointsProvider.points()[i].y
            )
        }

        canvas.drawPath(bezierCurvePath, bezierCurvePaint)
        bezierCurvePath.close()
    }
}