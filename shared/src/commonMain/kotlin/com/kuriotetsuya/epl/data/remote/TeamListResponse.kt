package com.kuriotetsuya.epl.data.remote

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TeamListResponse(
    @SerialName("teams")
    val teamList: List<TeamItemData>
)