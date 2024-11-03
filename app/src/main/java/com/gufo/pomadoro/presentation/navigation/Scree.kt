package com.gufo.pomadoro.presentation.navigation

sealed class Screen(val route: String) {
    data object SplashScreen : Screen("splash-screen")
    data object MainScreen : Screen("main-screen")
    data object HistoryScreen : Screen("history-screen")
    data object SettingsScreen : Screen("settings-screen") // только язык и тему можно сменить
}