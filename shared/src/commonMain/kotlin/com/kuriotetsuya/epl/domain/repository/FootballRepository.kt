package com.kuriotetsuya.epl.domain.repository

import com.kuriotetsuya.epl.domain.model.TeamData


internal interface FootballRepository {
    suspend fun getTeamList(name : String): List<TeamData>
}