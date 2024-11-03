package com.gufo.pomadoro.presentation.vms

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.gufo.pomadoro.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    var navControllerStatusScreen by mutableStateOf(Screen.MainScreen.route)

    fun navigate(route: String, navController: NavController,) {
        navControllerStatusScreen = route
        navController.navigate(route)
    }

}