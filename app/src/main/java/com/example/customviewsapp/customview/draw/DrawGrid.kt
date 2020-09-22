package com.example.customviewsapp.customview.draw

import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.customviewsapp.R
import com.example.customviewsapp.customview.contracts.DrawContract

class DrawGrid : DrawContract {

    private var numRows: Int = 7
    private var numColumns = 7
    private var lineWidth = 1f
    private var lineColor = Color.GRAY

    private val linePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = lineWidth
        color = lineColor
    }

    override fun setupTypedArray(typedArray: TypedArray) {
        lineColor = typedArray.getColor(R.styleable.LineView_grid_line_color, Color.GRAY)
        lineWidth = typedArray.getFloat(R.styleable.LineView_grid_line_width, 1f)
        numRows = typedArray.getInt(R.styleable.LineView_grid_line_rows, 7)
        numColumns = typedArray.getInt(R.styleable.LineView_grid_line_column, 7)

        linePaint.color = lineColor
        linePaint.strokeWidth = lineWidth
    }

    override fun onDraw(canvas: Canvas) {

        val currWidth = canvas.width
        val currHeight = canvas.height - 80

        val cellWidth = currWidth / numColumns
        val cellHeight = currHeight / numRows

        canvas.drawRect(0f, 0f, currWidth.toFloat(), currHeight.toFloat(), linePaint)
        drawVerticalLines(cellWidth, canvas, currHeight)
        drawHorizontalLines(cellHeight, canvas, currWidth)
    }

    private fun drawVerticalLines(cellWidth: Int, canvas: Canvas, currHeight: Int) {
        for (i in 1 until numColumns) {
            val x = (i * cellWidth).toFloat()
            canvas.drawLine(
                x, 0f,
                x, currHeight.toFloat(),
                linePaint
            )
        }
    }

    private fun drawHorizontalLines(cellHeight: Int, canvas: Canvas, currWidth: Int) {
        for (i in 1 until numRows) {
            val y = (i * cellHeight).toFloat()
            canvas.drawLine(
                0f, y,
                currWidth.toFloat(), y,
                linePaint
            )
        }
    }
}