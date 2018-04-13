package com.example.roman_zotov.marvelapp

import android.app.Application
import android.content.Context
import com.example.roman_zotov.marvelapp.ui.di.appModule
import com.example.roman_zotov.marvelapp.ui.di.charactersModule
import org.koin.android.ext.android.startKoin

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
        startKoin(this, listOf(appModule, charactersModule))
    }
}