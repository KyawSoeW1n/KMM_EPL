package com.kuriotetsuya.epl.android.common

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination {
    val title: String
    val route: String
    val routeWithArgs: String
}

object Home : Destination {
    override val title: String
        get() = "EPL"

    override val route: String
        get() = "home"

    override val routeWithArgs: String
        get() = route
}

object Detail : Destination {
    override val title: String
        get() = "Team details"

    override val route: String
        get() = "detail"

    override val routeWithArgs: String
        get() = "$route/{teamId}"

    val arguments = listOf(
        navArgument(name = "teamId") { type = NavType.IntType }
    )
}

val eplDestinations = listOf(Home, Detail)















