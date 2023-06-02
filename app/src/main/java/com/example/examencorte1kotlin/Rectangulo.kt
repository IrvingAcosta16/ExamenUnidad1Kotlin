package com.example.examencorte1kotlin

import kotlin.Float

class Rectangulo(private var base: Int, private var altura: Int) {
    private var total: Float = 0.toFloat()

    constructor() : this(0, 0)

    fun calcularArea(): Float {
        total = (base * altura).toFloat()
        return total
    }

    fun calcularPerimetro(): Float {
        total = (base * 2 + altura * 2).toFloat()
        return total
    }
}