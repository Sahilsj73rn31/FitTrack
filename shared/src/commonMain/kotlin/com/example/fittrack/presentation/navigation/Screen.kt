package com.example.fittrack.presentation.navigation


sealed class Screen(val route: String) {

    data object Splash : Screen("splash")

    data object Onboarding : Screen("onboarding")

    data object Login : Screen("login")

    data object Register : Screen("register")

    data object Home : Screen("home")

    data object Activity : Screen("activity")

    data object History : Screen("history")

    data object Leaderboard : Screen("leaderboard")

    data object Profile : Screen("profile")

    data object Settings : Screen("settings")
}