package com.gufo.pomadoro.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gufo.pomadoro.presentation.fragments.MainFragment
import com.gufo.pomadoro.presentation.fragments.SettingsFragment
import com.gufo.pomadoro.presentation.utils.FragmentManager

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    FragmentManager(
        navController = navController,
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.MainScreen.route
        ) {

            this.composable(
                route = Screen.MainScreen.route
            ) {
                MainFragment()
            }

            this.composable(
                route = Screen.HistoryScreen.route
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray))
            }

            this.composable(
                route = Screen.SettingsScreen.route
            ) {
                SettingsFragment()
            }

        }
    }

}