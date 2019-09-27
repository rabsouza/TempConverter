package com.example.tempconverter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tempconverter.R
import com.example.tempconverter.business.TemperatureCelciusBusiness
import com.example.tempconverter.business.TemperatureFahrenheitBusiness
import com.example.tempconverter.model.Temperature
import com.example.tempconverter.model.Type
import com.example.tempconverter.model.format
import com.example.tempconverter.presentation.TemperatureContract
import com.example.tempconverter.presentation.TemperaturePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TemperatureContract.View {

    lateinit var presenter: TemperaturePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = TemperaturePresenter(
            this,
            TemperatureCelciusBusiness(),
            TemperatureFahrenheitBusiness()
        )

        btnConvertTemp.setOnClickListener {
            when {
                txtTempValue.text.isNullOrBlank() -> {
                    txtTempValue.error = "Você deve informar uma temperatura!"
                    txtTempValue.requestFocus()
                }

                rbtTempCelcius.isChecked -> {
                    val temperature = Temperature(txtTempValue.text.toString().toDouble(), Type.CELCIUS)
                    presenter.onConverterTemperatureClick(temperature)
                }

                else -> {
                    val temperature = Temperature(txtTempValue.text.toString().toDouble(), Type.FARENHEIT)
                    presenter.onConverterTemperatureClick(temperature)
                }
            }
        }
    }

    override fun showResult(temperature: Double) {
        txtTempValue.setText(temperature.format(2))
    }
}
