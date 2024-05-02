package com.kuriotetsuya.epl.di

import com.kuriotetsuya.epl.data.remote.FootballService
import com.kuriotetsuya.epl.data.remote.RemoteDataSource
import com.kuriotetsuya.epl.data.repository.FootballRepositoryImpl
import com.kuriotetsuya.epl.domain.repository.FootballRepository
import com.kuriotetsuya.epl.domain.usecase.GetTeamListUseCase
import com.kuriotetsuya.epl.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { FootballService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<FootballRepository> { FootballRepositoryImpl(get()) }
    factory { GetTeamListUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules












