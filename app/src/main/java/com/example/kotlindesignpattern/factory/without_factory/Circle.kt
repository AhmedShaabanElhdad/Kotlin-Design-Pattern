package com.example.kotlindesignpattern.factory.without_factory

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint


class Circle(private val paint: Paint, private val canvas: Canvas, private val radius: Float) : Shape {

    override fun draw(x: Float, y: Float) {
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.strokeWidth = 3f

        //canvas.drawPaint(paint)
        // Use Color.parseColor to define HTML colors
        // Use Color.parseColor to define HTML colors
        //paint.color = Color.parseColor("#CD5C5C")
        canvas.drawCircle(x, y, radius, paint)
    }
}