package com.kuriotetsuya.epl.data.mapper

import com.kuriotetsuya.epl.data.remote.TeamItemData
import com.kuriotetsuya.epl.domain.model.TeamData

internal fun TeamItemData.toTeamData(): TeamData {
    return TeamData(
        idTeam = idTeam,
        name = strTeam
    )
}

//private fun getImageUrl(posterImage: String) = "https://image.tmdb.org/t/p/w500/$posterImage"