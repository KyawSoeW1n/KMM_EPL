package com.kuriotetsuya.epl.data.repository

import com.kuriotetsuya.epl.data.mapper.toTeamData
import com.kuriotetsuya.epl.data.remote.RemoteDataSource
import com.kuriotetsuya.epl.domain.model.TeamData
import com.kuriotetsuya.epl.domain.repository.FootballRepository

internal class FootballRepositoryImpl(
    private val remoteDateSource: RemoteDataSource
) : FootballRepository {
    override suspend fun getTeamList(name: String): List<TeamData> {
        return remoteDateSource.getTeamList(name = name).teamList.map {
            it.toTeamData()
        }
    }

}