package com.example.tempconverter.presentation

import com.example.tempconverter.model.Temperature

class TemperatureContract {

    interface View {
        fun showResult(temperature: Double)
    }

    interface Presenter {
        fun onConverterTemperatureClick(temperature: Temperature)
    }

}