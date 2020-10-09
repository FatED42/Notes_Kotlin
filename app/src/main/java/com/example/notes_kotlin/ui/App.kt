package com.example.notes_kotlin.ui

import android.app.Application
import com.example.notes_kotlin.di.appModule
import com.example.notes_kotlin.di.mainModule
import com.example.notes_kotlin.di.noteModule
import com.example.notes_kotlin.di.splashModule
import org.koin.android.ext.android.startKoin

class App: Application() {

    companion object{
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin(this, listOf(appModule, splashModule, mainModule, noteModule))
    }
}