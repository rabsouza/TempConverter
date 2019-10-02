package com.example.tempconverter.business

import com.example.tempconverter.model.Temperature

class TemperatureFahrenheitBusiness : TemperatureBusiness {

    override fun calcule(temperature: Temperature) = (temperature.temperature - 32) * 5 / 9

}