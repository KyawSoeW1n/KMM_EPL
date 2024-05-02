package com.kuriotetsuya.epl.data.remote

import com.kuriotetsuya.epl.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val apiService: FootballService,
    private val dispatcher: Dispatcher
) {

    suspend fun getTeamList(name: String) = withContext(dispatcher.io) {
        apiService.getTeamList(name)
    }

}