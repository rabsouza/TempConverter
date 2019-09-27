package com.example.tempconverter.presentation

import com.example.tempconverter.business.TemperatureBusiness
import com.example.tempconverter.model.Temperature
import com.example.tempconverter.model.Type
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TemperaturePresenterTest{

    @MockK
    lateinit var business: TemperatureBusiness

    @MockK
    lateinit var view: TemperatureContract.View

    @InjectMockKs
    lateinit var presenter: TemperaturePresenter

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)

    @Test
    fun `onConverterTemperatureClick - calcula e exibe a temperatura convertida para CELCIUS`(){
        val temperature = mockk<Temperature>()
        every { temperature.type } returns Type.CELCIUS

        presenter.onConverterTemperatureClick(temperature)

        verify { business.calcule(any()) }
        verify { view.showResult(any()) }
    }

    @Test
    fun `onConverterTemperatureClick - calcula e exibe a temperatura convertida para FARENHEIT`(){
        val temperature = mockk<Temperature>()
        every { temperature.type } returns Type.FARENHEIT

        presenter.onConverterTemperatureClick(temperature)

        verify { business.calcule(any()) }
        verify { view.showResult(any()) }
    }
}