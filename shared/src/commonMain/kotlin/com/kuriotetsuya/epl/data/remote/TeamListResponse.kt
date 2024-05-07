package com.kuriotetsuya.epl.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamListResponse(
    @SerialName("teams")
    val teamList: List<TeamItemData>
)