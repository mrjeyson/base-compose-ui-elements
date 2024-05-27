package com.jsoft.myapplication.coreui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController

interface ScreenNavigationSpec {
    val route: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()

    val navOptions: NavOptions
        get() = NavOptions.Builder().build()

    @Composable
    fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
    )
}
