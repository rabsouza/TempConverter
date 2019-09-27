package com.example.tempconverter.model

fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

enum class Type {
    CELCIUS, FARENHEIT
}

data class Temperature(val temperature: Double, val type: Type)