package com.example.kotlindesignpattern.factory.without_factory

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint


class Circle(private val paint: Paint, private val canvas: Canvas, private val radius: Float) {

    fun draw(x: Float, y: Float) {
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.strokeWidth = 3f
        canvas.drawCircle(x, y, radius, paint)
    }
}
