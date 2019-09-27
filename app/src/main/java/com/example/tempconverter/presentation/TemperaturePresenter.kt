package com.example.tempconverter.presentation

import com.example.tempconverter.business.TemperatureBusiness
import com.example.tempconverter.model.Temperature
import com.example.tempconverter.model.Type

class TemperaturePresenter(
    private val view: TemperatureContract.View,
    private val celciusBusiness: TemperatureBusiness,
    private val fahrenheitBusiness: TemperatureBusiness
) : TemperatureContract.Presenter {

    override fun onConverterTemperatureClick(temperature: Temperature) {
        var result =
            when (temperature.type) {
                Type.CELCIUS -> celciusBusiness.calcule(temperature)
                Type.FARENHEIT -> fahrenheitBusiness.calcule(temperature)
            }

        view.showResult(result)
    }

}