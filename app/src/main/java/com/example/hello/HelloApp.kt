package com.example.hello

import android.app.Application
import com.facebook.stetho.Stetho

class HelloApp: Application (){
    override fun onCreate(){
        super.onCreate()
        var context = null
        Stetho.initializeWithDefaults( context: this)
    }
}

class Stetho
