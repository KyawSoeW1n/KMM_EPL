package com.kuriotetsuya.epl.util

import com.kuriotetsuya.epl.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}