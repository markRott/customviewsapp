package com.example.customviewsapp.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.customviewsapp.R
import com.example.customviewsapp.customview.contracts.PointsProviderContract
import com.example.customviewsapp.customview.draw.DrawBezierCurve
import com.example.customviewsapp.customview.draw.DrawCircle
import com.example.customviewsapp.customview.draw.DrawGrid

class LineView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val drawGrid: DrawGrid by lazy { DrawGrid() }
    private val pointsProvider: PointsProviderContract by lazy { PointsProvider }
    private val drawBezierCurve: DrawBezierCurve by lazy { DrawBezierCurve(pointsProvider) }
    private val drawCircle: DrawCircle by lazy { DrawCircle(pointsProvider) }

    init {
        readAttributeSet(attrs)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) return

        drawGrid.onDraw(canvas)
        drawBezierCurve.onDraw(canvas)
        drawCircle.onDraw(canvas)
    }

    private fun readAttributeSet(attrs: AttributeSet?) {
        if (attrs == null) return

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LineView)

        drawGrid.setupTypedArray(typedArray)
        drawBezierCurve.setupTypedArray(typedArray)
        drawCircle.setupTypedArray(typedArray)

        typedArray.recycle()
    }
}