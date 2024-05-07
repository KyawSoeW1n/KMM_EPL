package com.kuriotetsuya.epl.data.remote

@kotlinx.serialization.Serializable
data class TeamItemData(
    val idTeam: String,
    val strTeam: String,
    val strTeamBadge: String,
    val strTeamShort: String,
)

