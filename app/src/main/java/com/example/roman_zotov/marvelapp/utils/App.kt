package com.example.roman_zotov.marvelapp.utils

import android.app.Application
import android.content.Context

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class App : Application() {

    companion object {
        lateinit var appContext: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}