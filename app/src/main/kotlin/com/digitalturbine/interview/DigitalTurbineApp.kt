package com.digitalturbine.interview

import android.app.Application

/**
 * Digital Turbine - Code challenge app.
 */
class DigitalTurbineApp: Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        lateinit var context: DigitalTurbineApp private set
    }
}