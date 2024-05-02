package com.kuriotetsuya.epl.domain.usecase

import com.kuriotetsuya.epl.domain.model.TeamData
import com.kuriotetsuya.epl.domain.repository.FootballRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetTeamListUseCase : KoinComponent {
    private val repository: FootballRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(name: String): List<TeamData> {
        return repository.getTeamList(name = name)
    }
}