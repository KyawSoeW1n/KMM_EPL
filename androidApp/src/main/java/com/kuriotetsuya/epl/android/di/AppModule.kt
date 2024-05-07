package com.kuriotetsuya.epl.android.di

import com.kuriotetsuya.epl.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
}