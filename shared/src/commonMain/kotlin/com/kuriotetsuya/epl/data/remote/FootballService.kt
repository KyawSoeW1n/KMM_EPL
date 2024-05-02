package com.kuriotetsuya.epl.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class FootballService : KtorApi() {
    suspend fun getTeamList(name: String): TeamListResponse = client.get {
        pathUrl("search_all_teams.php")
        parameter("i", name)
    }.body()
}