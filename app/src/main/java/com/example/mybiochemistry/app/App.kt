package com.example.mybiochemistry.app

import android.app.Application
import android.content.Context
import com.google.firebase.FirebaseApp

class App : Application() {
    companion object{
        lateinit var dm: DataManager
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        dm = DataManager(baseContext)
        dm.initEncryptedSharedPrefs(baseContext)
        appContext = applicationContext
    }
}