package com.jadhavrupesh22.hilt_base.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltBaseApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}