package com.example.tempconverter.view.robot

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.tempconverter.R
import com.example.tempconverter.model.format

class MainRobot {

    fun fillTempConverter(temp: String) = apply {
        onView(withId(R.id.txtTempValue))
            .perform(replaceText(temp), closeSoftKeyboard())
    }

    fun checkTempConverter(temp: Double) = apply {
        onView(withId(R.id.txtTempValue))
            .check(matches(withText(temp.format(2))))
    }

    fun checkTempConverterError() = apply {
        onView(withId(R.id.txtTempValue))
            .check(matches(hasErrorText("Você deve informar uma temperatura!")));
    }

    fun clickCelciusOption() = apply {
        onView(withId(R.id.rbtTempCelcius))
            .perform(click())
    }

    fun clickFarenheitOption() = apply {
        onView(withId(R.id.rbtTempFarenheit))
            .perform(click())
    }

    fun clickConverter() = apply {
        onView(withId(R.id.btnConvertTemp))
            .perform(click())
    }

}