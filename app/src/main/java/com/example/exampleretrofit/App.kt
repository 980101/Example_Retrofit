package com.example.exampleretrofit

import android.app.Application

// 최상단의 context를 가져오기 위한 액티비티
class App: Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}