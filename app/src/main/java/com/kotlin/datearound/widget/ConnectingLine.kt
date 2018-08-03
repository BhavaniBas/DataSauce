package com.kotlin.datearound.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import java.security.AccessControlContext

class ConnectingLine(context: Context, yPos: Float, mConnectingLineWeight: Float, mConnectingLineColor: Int) {

    // Member Variables ////////////////////////////////////////////////////////

    var mPaint: Paint? = null

    var mY: Float = 0.0f

    // Constructor /////////////////////////////////////////////////////////////

    /**
     * Constructor for connecting line
     *
     * @param ctx                  the context for the line
     * @param y                    the y co-ordinate for the line
     * @param connectingLineWeight the weight of the line
     * @param connectingLineColor  the color of the line
     */
    fun ConnectingLine(ctx: Context, y: Float, connectingLineWeight: Float,
                       connectingLineColor: Int)  {

        val res = ctx.resources

        // Initialize the paint, set values
        mPaint = Paint()
        mPaint!!.color = connectingLineColor
        mPaint!!.strokeWidth = connectingLineWeight
        mPaint!!.strokeCap = Paint.Cap.ROUND
        mPaint!!.isAntiAlias = true

        mY = y
    }

    // Package-Private Methods /////////////////////////////////////////////////

    /**
     * Draw the connecting line between the two thumbs in rangebar.
     *
     * @param canvas     the Canvas to draw to
     * @param leftThumb  the left thumb
     * @param rightThumb the right thumb
     */
    fun draw(canvas: Canvas, leftThumb: PinView, rightThumb: PinView) {
        canvas.drawLine(leftThumb.getX(), mY, rightThumb.getX(), mY, mPaint)
    }

    /**
     * Draw the connecting line between for single slider.
     *
     * @param canvas     the Canvas to draw to
     * @param rightThumb the right thumb
     * @param leftMargin the left margin
     */
    /*fun draw(canvas: Canvas, leftMargin: Float, rightThumb: PinView) {
        canvas.drawLine(leftMargin, mY, rightThumb.getX(), mY, mPaint)
    }*/

    fun draw(canvas: Canvas, marginLeft: Float, mRightThumb: PinView) {
        canvas.drawLine(marginLeft, mY, mRightThumb.getX(), mY, mPaint)
    }
}