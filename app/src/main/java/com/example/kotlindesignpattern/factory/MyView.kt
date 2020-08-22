package com.example.kotlindesignpattern.factory

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.example.kotlindesignpattern.factory.factory.FactoryShape
import com.example.kotlindesignpattern.factory.factory.Shape
import com.example.kotlindesignpattern.factory.factory.Type
import com.example.kotlindesignpattern.factory.without_factory.Circle
import com.example.kotlindesignpattern.factory.without_factory.Rectangle
import com.example.kotlindesignpattern.factory.without_factory.Square

class MyView constructor(
    context: Context
) : View(context) {
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {

        val paint = Paint()


        //Normal way  without Factory Design Pattern
        /*
        val circle: Circle = Circle(paint, canvas!!, 50f)
        val rectangle: Rectangle = Rectangle(paint, canvas, 200, 100)
        val square: Square = Square(paint, canvas, 100)

        circle.draw(80f, 90f)
        rectangle.draw(20f, 160f)
        square.draw(20f, 310f)
         */


        //Factory Design pattern

        val factory = FactoryShape(paint,canvas!!)
        factory.radius=50f

        val circle:Shape  = factory.createShape(Type.CIRCLE)!!
        circle.draw(80f, 90f)

        factory.width = 200
        factory.height = 100
        val rectangle:Shape  = factory.createShape(Type.RECTANGLE)!!
        rectangle.draw(80f, 90f)

        val square:Shape  = factory.createShape(Type.SQUARE)!!
        square.draw(20f, 310f)



    }
}
