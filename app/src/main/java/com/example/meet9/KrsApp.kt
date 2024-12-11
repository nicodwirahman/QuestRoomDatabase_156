package com.example.meet9

import android.app.Application
import com.example.meet9.dependecieinjection.ContainerApp

class KrsApp: Application(){
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()

        containerApp = ContainerApp(this)
    }
}