package com.example.customviewsapp.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.example.customviewsapp.R
import com.example.customviewsapp.customview.contracts.PointsProviderContract
import com.example.customviewsapp.customview.draw.DrawBezierCurve
import com.example.customviewsapp.customview.draw.DrawCircle
import com.example.customviewsapp.customview.draw.DrawGrid
import com.example.customviewsapp.showToast
import kotlin.math.abs

class LineView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val drawGrid: DrawGrid by lazy { DrawGrid() }
    private val pointsProvider: PointsProviderContract by lazy { PointsProvider() }
    private val drawBezierCurve: DrawBezierCurve by lazy { DrawBezierCurve(pointsProvider) }
    private val drawCircle: DrawCircle by lazy { DrawCircle(pointsProvider) }

    init {
        readAttributeSet(attrs)
    }

    private fun readAttributeSet(attrs: AttributeSet?) {
        if (attrs == null) return

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LineView)

        drawGrid.setupTypedArray(typedArray)
        drawBezierCurve.setupTypedArray(typedArray)
        drawCircle.setupTypedArray(typedArray)

        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) return

        canvas.save()
        canvas.translate(0f, height.toFloat())
        canvas.scale(1f, -1f)

        drawGrid.onDraw(canvas)
        drawBezierCurve.onDraw(canvas)
        drawCircle.onDraw(canvas)

        canvas.restore()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_UP -> {
                val currX = event.x
                val currY = abs((event.y - height))
                pointsProvider.pointsClickData().firstOrNull {
                    (currX >= it.xValues.first && currX <= it.xValues.second) &&
                            (currY >= it.yValues.first && currY <= it.yValues.second)
                }?.let { context.showToast(it.label) }
            }
        }
        return true
    }
}