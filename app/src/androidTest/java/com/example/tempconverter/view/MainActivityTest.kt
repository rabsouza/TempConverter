package com.example.tempconverter.view

import android.content.Context
import android.content.Intent
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.tempconverter.view.robot.MainRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    private lateinit var context: Context

    @Rule
    @JvmField
    var testRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setup(){
        testRule.launchActivity(Intent())
        context = testRule.activity.applicationContext
    }

    @Test
    fun valida_msg_error_qdo_temperatura_nao_preenchido(){
        MainRobot()
            .clickConverter()
            .checkTempConverterError()
    }

    @Test
    fun valida_converter_0F_para_17C_negativo(){
        MainRobot()
            .fillTempConverter("0.0")
            .clickFarenheitOption()
            .clickConverter()
            .checkTempConverter(-17.78)
    }

    @Test
    fun valida_converter_0C_para_32F(){
        MainRobot()
            .fillTempConverter("0.0")
            .clickCelciusOption()
            .clickConverter()
            .checkTempConverter(32.0)
    }


}