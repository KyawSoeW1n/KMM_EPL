package com.kuriotetsuya.epl.android.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuriotetsuya.epl.domain.model.TeamData
import com.kuriotetsuya.epl.domain.usecase.GetTeamListUseCase
import kotlinx.coroutines.launch


class HomeViewModel(
    val getTeamListUseCase: GetTeamListUseCase
) : ViewModel() {
    var uiState by mutableStateOf(HomeScreenState())


    init {
        loadTeamList()
    }

    fun loadTeamList() {
        if (uiState.loading) return

        viewModelScope.launch {
            uiState = uiState.copy(
                loading = true,
                refresh = true,
            )

            try {
                val resultTeamList = getTeamListUseCase("English Premier League")
                System.out.println(">>>> ${resultTeamList.size}")
                uiState = uiState.copy(
                    loading = false,
                    refresh = false,
                    loadFinished = resultTeamList.isEmpty(),
                    teamList = resultTeamList
                )

            } catch (error: Throwable) {
                uiState = uiState.copy(
                    loading = false,
                    refresh = false,
                    loadFinished = true,
                    errorMessage = "Could not load team list: ${error.localizedMessage}"
                )
            }
        }
    }
}

data class HomeScreenState(
    var loading: Boolean = false,
    var refresh: Boolean = false,
    var teamList: List<TeamData> = listOf(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false
)