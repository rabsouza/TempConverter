package com.example.tempconverter.business

import com.example.tempconverter.model.Temperature

class TemperatureCelciusBusiness: TemperatureBusiness {

    override fun calcule(temperature: Temperature) = temperature.temperature * 9 / 5 + 32

}