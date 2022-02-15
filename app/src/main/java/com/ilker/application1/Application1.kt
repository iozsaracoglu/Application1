package com.ilker.application1

import android.app.Application
import timber.log.Timber

class Application1 : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}