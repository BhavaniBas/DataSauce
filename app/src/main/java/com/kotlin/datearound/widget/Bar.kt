package com.kotlin.datearound.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import java.security.AccessControlContext

class Bar(context: Context?, marginLeft: Float, yPos: Float, barLength: Float, mTickCount: Int, mTickHeight: Float, mTickColor: Int, mBarWeight: Float, mBarColor: Int, mIsBarRounded: Boolean) {

    var mBarPaint: Paint? = null

    var mTickPaint: Paint? = null

    // Left-coordinate of the horizontal bar.
    var mLeftX: Float = 0.0f

    var mRightX: Float = 0.0f

    var mY: Float = 0.0f

    var mNumSegments: Int = 0

    var mTickDistance: Float = 0.toFloat()

    var mTickHeight: Float = 0.0f

    // Constructor /////////////////////////////////////////////////////////////


    /**
     * Bar constructor
     *
     * @param ctx        the context
     * @param x          the start x co-ordinate
     * @param y          the y co-ordinate
     * @param length     the length of the bar in px
     * @param tickCount  the number of ticks on the bar
     * @param tickHeight the height of each tick
     * @param tickColor  the color of each tick
     * @param barWeight  the weight of the bar
     * @param barColor   the color of the bar
     * @param isBarRounded if the bar has rounded edges or not
     */
    fun Bar(ctx: Context,
            x: Float,
            y: Float,
            length: Float,
            tickCount: Int,
            tickHeight: Float,
            tickColor: Int,
            barWeight: Float,
            barColor: Int,
            isBarRounded: Boolean)  {

        mLeftX = x
        mRightX = x + length
        mY = y

        mNumSegments = tickCount - 1
        mTickDistance = length / mNumSegments
        mTickHeight = tickHeight
        // Initialize the paint.
        mBarPaint = Paint()
        mBarPaint!!.color = barColor
        mBarPaint!!.strokeWidth = barWeight
        mBarPaint!!.isAntiAlias = true
        if (isBarRounded) {
            mBarPaint!!.strokeCap = Paint.Cap.ROUND
        }
        mTickPaint = Paint()
        mTickPaint!!.color = tickColor
        mTickPaint!!.strokeWidth = barWeight
        mTickPaint!!.isAntiAlias = true
    }

    // Package-Private Methods /////////////////////////////////////////////////

    /**
     * Draws the bar on the given Canvas.
     *
     * @param canvas Canvas to draw on; should be the Canvas passed into {#link
     * View#onDraw()}
     */
    fun draw(canvas: Canvas) {

        canvas.drawLine(mLeftX, mY, mRightX, mY, mBarPaint)
    }

    /**
     * Get the x-coordinate of the left edge of the bar.
     *
     * @return x-coordinate of the left edge of the bar
     */
    fun getLeftX(): Float {
        return mLeftX
    }

    /**
     * Get the x-coordinate of the right edge of the bar.
     *
     * @return x-coordinate of the right edge of the bar
     */
    fun getRightX(): Float {
        return mRightX
    }

    /**
     * Gets the x-coordinate of the nearest tick to the given x-coordinate.
     *
     * @param thumb the thumb to find the nearest tick for
     * @return the x-coordinate of the nearest tick
     */
    fun getNearestTickCoordinate(thumb: PinView?): Float {

        val nearestTickIndex = getNearestTickIndex(thumb)

        return mLeftX + nearestTickIndex * mTickDistance
    }

    /**
     * Gets the zero-based index of the nearest tick to the given thumb.
     *
     * @param thumb the Thumb to find the nearest tick for
     * @return the zero-based index of the nearest tick
     */
    fun getNearestTickIndex(thumb: PinView?): Int {

        var tickIndex = ((thumb!!.getX() - mLeftX + mTickDistance / 2f) / mTickDistance) as Int

        if (tickIndex > mNumSegments) {
            tickIndex = mNumSegments
        } else if (tickIndex < 0) {
            tickIndex = 0
        }
        return tickIndex
    }


    /**
     * Set the number of ticks that will appear in the RangeBar.
     *
     * @param tickCount the number of ticks
     */
    fun setTickCount(tickCount: Int) {

        val barLength = mRightX - mLeftX

        mNumSegments = tickCount - 1
        mTickDistance = barLength / mNumSegments
    }

    // Private Methods /////////////////////////////////////////////////////////

    /**
     * Draws the tick marks on the bar.
     *
     * @param canvas Canvas to draw on; should be the Canvas passed into {#link
     * View#onDraw()}
     */
    fun drawTicks(canvas: Canvas) {

        // Loop through and draw each tick (except final tick).
        for (i in 0 until mNumSegments) {
            val x = i * mTickDistance + mLeftX
            canvas.drawCircle(x, mY, mTickHeight, mTickPaint)
        }
        // Draw final tick. We draw the final tick outside the loop to avoid any
        // rounding discrepancies.
        canvas.drawCircle(mRightX, mY, mTickHeight, mTickPaint)
    }
}