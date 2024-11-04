package com.gufo.pomadoro.presentation.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gufo.pomadoro.R
import com.gufo.pomadoro.domain.restartActivity
import com.gufo.pomadoro.domain.setLocale
import com.gufo.pomadoro.presentation.utils.PrimaryFragmentContainer
import com.gufo.pomadoro.presentation.vms.MainViewModel

@Composable
fun SettingsFragment(
    viewModel: MainViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    PrimaryFragmentContainer(title = R.string.title_settings) {


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {


            Button(onClick = {
                setLocale(context, "en") // Устанавливаем английский
                // restartActivity(context)
            }) {
                Text("English")
            }
            Button(onClick = {
                setLocale(context, "ru") // Устанавливаем русский
                // restartActivity(context)
            }) {
                Text("Русский")
            }

        }

    }

}