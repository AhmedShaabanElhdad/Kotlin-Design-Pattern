package com.example.kotlindesignpattern.factory.factory

import android.graphics.Canvas
import android.graphics.Paint

class FactoryShape(
    private val paint: Paint,
    private val canvas: Canvas,
    var width: Int = 0,
    var height: Int = 0,
    var radius: Float = 0f
) {


    fun createShape(type: Type?): Shape? {
        var shape: Shape? = null
        when (type) {
            Type.CIRCLE -> shape = Circle(paint, canvas, radius)
            Type.SQUARE -> shape = Square(paint, canvas, width)
            Type.RECTANGLE -> shape = Rectangle(paint, canvas, width, height)
        }
        return shape
    }
}

enum class Type {
    CIRCLE, SQUARE, RECTANGLE
}



object FactoryShape2 {

    enum class Type {
        CIRCLE, SQUARE, RECTANGLE
    }

    fun createShape(type: Type?,paint: Paint, canvas: Canvas, width: Int = 0, height: Int = 0, radius: Float = 0f): Shape? {
        var shape: Shape? = null
        when (type) {
            Type.CIRCLE -> shape = Circle(paint,canvas,radius)
            Type.SQUARE -> shape = Square(paint, canvas, width)
            Type.RECTANGLE -> shape = Rectangle(paint, canvas, width, height)
        }
        return shape
    }
}

