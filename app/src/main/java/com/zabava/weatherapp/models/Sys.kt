package com.zabava.weatherapp.models
import java.io.Serializable


data class Sys (
    val type: Int,
    val id: Double,
    val country: String,
    val sunrise: Double,
    val sunset: Double,
        ):Serializable