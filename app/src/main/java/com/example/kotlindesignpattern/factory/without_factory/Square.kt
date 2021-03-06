package com.example.kotlindesignpattern.factory.without_factory

import android.R
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect

class Square(val paint: Paint, val canvas: Canvas, val width: Int){

    fun draw(x: Float, y: Float) {
        paint.style = Paint.Style.FILL
        paint.color = Color.MAGENTA
        paint.strokeWidth = 3f
        val rect = Rect()
        rect.left = x.toInt()
        rect.top = y.toInt()
        rect.right = x.toInt() + width
        rect.bottom = y.toInt() + width

        canvas.drawRect(rect, paint)
    }

}
