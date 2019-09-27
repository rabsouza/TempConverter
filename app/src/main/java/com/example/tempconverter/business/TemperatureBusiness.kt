package com.example.tempconverter.business

import com.example.tempconverter.model.Temperature

interface TemperatureBusiness {

    fun calcule(temperature: Temperature): Double
}