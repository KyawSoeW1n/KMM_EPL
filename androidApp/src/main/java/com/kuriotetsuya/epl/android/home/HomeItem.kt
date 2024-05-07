package com.kuriotetsuya.epl.android.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.kuriotetsuya.epl.domain.model.TeamData

@Composable
fun HomeItem(
    teamData: TeamData, modifier: Modifier = Modifier, onMovieClick: (TeamData) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = teamData.url,
            contentDescription = null,

        )
        Text(text = teamData.name)
    }
}