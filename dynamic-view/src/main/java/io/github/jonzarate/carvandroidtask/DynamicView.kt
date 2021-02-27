package io.github.jonzarate.carvandroidtask

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.max
import kotlin.math.min

class DynamicView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // X, Y, radius
    var coordinates: List<List<Double>>? = null
        set(value) {
            field = value
            findMaxWidthHeight(value)
            invalidate()
        }

    var maxWidth = 0.0
    var maxHeight = 0.0

    var maxRadius = 0.0

    private val paint = Paint()

    private fun findMaxWidthHeight(coordinates: List<List<Double>>?) {
        var highestWidth = 0.0
        var highestHeight = 0.0
        var highestRadius = 0.0

        coordinates?.forEach { coordinate ->
            val currentWidth = coordinate[0]
            val currentHeight = coordinate[1]
            val currentRadius = coordinate[2]

            if (currentWidth > highestWidth)
                highestWidth = currentWidth

            if (currentHeight > highestHeight)
                highestHeight = currentHeight

            if (currentRadius > highestRadius)
                highestRadius = currentRadius
        }

        maxWidth = highestWidth + (highestRadius * 2)
        maxHeight = highestHeight + (highestRadius * 2)
        maxRadius = highestRadius
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val desiredWidth = maxWidth
        val desiredHeight = maxHeight

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width: Int
        val height: Int

        width = when (widthMode) {
            MeasureSpec.EXACTLY -> widthSize
            MeasureSpec.AT_MOST -> min(desiredWidth.toInt(), widthSize)
            else -> max(desiredWidth.toInt(), widthSize)
        }

        height = when (heightMode) {
            MeasureSpec.EXACTLY -> heightSize
            MeasureSpec.AT_MOST -> min(desiredHeight.toInt(), heightSize)
            else -> max(desiredHeight.toInt(), heightSize)
        }

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val availableWidth = (measuredWidth - (maxRadius * 2))
        val availableHeight = (measuredHeight - (maxRadius * 2))

        val widthMultiplier = (availableWidth / maxWidth)
        val heightMultiplier = (availableHeight / maxHeight)
        val multiplier = min(heightMultiplier, widthMultiplier).toFloat()

        val radiusPadding = maxRadius.toFloat() * multiplier

        val emptySpaceWidth = (availableWidth  - (maxWidth * multiplier)).toFloat()
        val emptySpaceHeight = (availableHeight  - (maxHeight * multiplier)).toFloat()

        paint.style = Paint.Style.FILL
        canvas?.drawRect(0F, 0F, emptySpaceWidth, emptySpaceHeight, paint)

        val widthPadding = radiusPadding + (emptySpaceWidth / 2)
        val heightPadding = radiusPadding + (emptySpaceHeight / 2)

        coordinates?.forEach { coordinate ->
            canvas?.drawCircle(
                widthPadding + (coordinate[0].toFloat() * multiplier),
                heightPadding + (coordinate[1].toFloat() * multiplier),
                coordinate[2].toFloat() * multiplier,
                paint)
        }
    }

}