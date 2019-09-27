package com.example.tempconverter.business

import com.example.tempconverter.model.Temperature
import com.example.tempconverter.model.Type
import com.example.tempconverter.model.format
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Test

class TemperatureCelciusBusinessTest{

    @Test
    fun `calcule - converter de 0 ºC para 32 ºF`(){
        val temperature = Temperature(0.0, Type.CELCIUS)
        val result = TemperatureCelciusBusiness().calcule(temperature)

        val expected = 32.0
        assertThat(result.format(2), CoreMatchers.equalTo(expected.format(2)))
    }
}