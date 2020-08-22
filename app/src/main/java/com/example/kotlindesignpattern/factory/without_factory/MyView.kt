package com.example.kotlindesignpattern.factory.without_factory

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyView constructor(
    context: Context
) : View(context) {
    override fun onDraw(canvas: Canvas?) {


        val paint = Paint()
        paint.setColor(Color.rgb(0, 0, 0))
        paint.setStrokeWidth(10f)

        val circle: Circle = Circle(paint, canvas!!, 50f)
        val rectangle: Rectangle = Rectangle(paint, canvas, 200, 100)
        val square: Square = Square(paint, canvas, 100)

        circle.draw(80f, 90f)
        rectangle.draw(20f, 160f)
        square.draw(20f, 310f)


    }
}
