package com.example.kotlindesignpattern.factory.factory

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect


class Rectangle(val paint: Paint, val canvas: Canvas, val width: Int, val height: Int):Shape{

    override fun draw(x: Float, y: Float) {
        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        paint.strokeWidth = 3f
        val rect = Rect()
        rect.left = x.toInt()
        rect.top = y.toInt()
        rect.right = x.toInt() + width
        rect.bottom = y.toInt() + height

        canvas.drawRect(rect, paint)
    }

}
