package com.example.tempconverter.business

import com.example.tempconverter.model.Temperature
import com.example.tempconverter.model.Type
import com.example.tempconverter.model.format
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test

class TemperatureFahrenheitBusinessTest{

    @Test
    fun `calcule - converter de 0 ºF para -17 ºC`(){
        val temperature = Temperature(0.0, Type.FARENHEIT)
        val result = TemperatureFahrenheitBusiness().calcule(temperature)

        val expected: Double = -17.78
        assertThat(result.format(2), equalTo(expected.format(2)))
    }

}