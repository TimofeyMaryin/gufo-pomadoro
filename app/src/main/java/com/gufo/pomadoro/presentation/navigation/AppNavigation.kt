package com.gufo.pomadoro.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {

        this.composable(
            route = Screen.SplashScreen.route
        ) {

        }

        this.composable(
            route = Screen.MainScreen.route
        ) {

        }

        this.composable(
            route = Screen.HistoryScreen.route
        ) {

        }

        this.composable(
            route = Screen.SettingsScreen.route
        ) {

        }

    }

}