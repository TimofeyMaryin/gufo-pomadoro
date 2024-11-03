package com.gufo.pomadoro.presentation.utils

import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gufo.pomadoro.R
import com.gufo.pomadoro.presentation.navigation.Screen
import com.gufo.pomadoro.presentation.vms.MainViewModel

@Composable
fun FragmentManager(
    navController: NavController,
    content: @Composable () -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Container(weight = 10f) {
            content()
        }

        BottomBar(navController = navController)
    }

}

@Composable
private fun ColumnScope.BottomBar(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController,
) {

    Container(weight = 1f) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            BottomBarItem(
                ic = Icons.Default.Star,
                title = R.string.title_1,
                status = viewModel.navControllerStatusScreen == Screen.MainScreen.route
            ) {
                if (viewModel.navControllerStatusScreen != Screen.MainScreen.route) {
                    viewModel.navigate(Screen.MainScreen.route, navController)
                }
            }

            BottomBarItem(
                ic = Icons.Default.Menu,
                title = R.string.title_2,
                status = viewModel.navControllerStatusScreen == Screen.HistoryScreen.route
            ) {
                if (viewModel.navControllerStatusScreen != Screen.HistoryScreen.route) {
                    viewModel.navigate(Screen.HistoryScreen.route, navController)
                }
            }

            BottomBarItem(
                ic = Icons.Default.Settings,
                title = R.string.title_3,
                status = viewModel.navControllerStatusScreen == Screen.SettingsScreen.route
            ) {
                if (viewModel.navControllerStatusScreen != Screen.SettingsScreen.route) {
                    viewModel.navigate(Screen.SettingsScreen.route, navController)
                }
            }
        }
    }

}

@Composable
fun RowScope.BottomBarItem(
    ic: ImageVector,
    @StringRes title: Int,
    status: Boolean,
    onClick: () -> Unit,
) {

    val contentColor by animateColorAsState(targetValue = if (status) Color.Blue else Color.Gray)

    Container(weight = 1f) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Icon(
                imageVector = ic,
                contentDescription = null,
                modifier = Modifier.size(35.dp),
                tint = contentColor
            )

            AppText(
                value = stringResource(id = title),
                textSize = TextSize.SMALL,
                fontWeight = FWeight.REGULAR,
                color = contentColor
            )
        }
    }

}