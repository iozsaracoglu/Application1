package com.ilker.application1

import android.app.Application
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import timber.log.Timber

class Application1 : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}