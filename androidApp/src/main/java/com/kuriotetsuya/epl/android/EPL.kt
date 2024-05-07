package com.kuriotetsuya.epl.android

import android.app.Application
import com.kuriotetsuya.epl.android.di.appModule
import com.kuriotetsuya.epl.di.getSharedModules
import org.koin.core.context.startKoin

class EPL : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}