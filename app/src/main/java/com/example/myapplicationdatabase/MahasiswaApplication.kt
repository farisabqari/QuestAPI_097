package com.example.myapplicationdatabase

import android.app.Application
import com.example.myapplicationdatabase.Depedencies.AppContainer
import com.example.myapplicationdatabase.Depedencies.MahasiswaContainer

class MahasiswaApplication:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }

}