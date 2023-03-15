@file:Suppress("DEPRECATION")

package com.zabava.weatherapp

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object Constants {

    const val APP_ID: String = "3a4bb7dc818ee5a2f060b636426e7050"
    const val BASE_URL: String = "https://api.openweathermap.org/data/"
    const val METRIC_UNI: String = "metric"


    @SuppressLint("ServiceCast")
    fun isNetworkAvailable(context: Context): Boolean {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network)

            return when{
                activeNetwork!!.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                activeNetwork!!.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false

            }

        }else{
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo !=null && networkInfo.isConnectedOrConnecting
        }

    }
}