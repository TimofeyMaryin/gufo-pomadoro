package com.gufo.pomadoro.presentation.fragments

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gufo.pomadoro.R
import com.gufo.pomadoro.presentation.canvas.ClockScreen
import com.gufo.pomadoro.presentation.utils.FragmentManager
import com.gufo.pomadoro.presentation.utils.PrimaryFragmentContainer
import com.gufo.pomadoro.presentation.vms.MainViewModel
import com.gufo.pomadoro.ui.theme.primary
import com.gufo.pomadoro.ui.theme.surface

@Composable
fun MainFragment(
    viewModel: MainViewModel = hiltViewModel()
) {

    val hourHandHeight = 140.dp
    val hourHandWidth = 5.dp
    var hourHandTiltAngel by remember { mutableStateOf(0f) }

    PrimaryFragmentContainer(
        title = R.string.title_main
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectVerticalDragGestures(
                        onVerticalDrag = { change, dragAmount ->
                            change.consume()
                            hourHandTiltAngel += dragAmount / 10
                            Log.e("TAG", "MainFragment hourHandTiltAngel: $hourHandTiltAngel",)
                        }
                    )
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            ClockScreen(hourHandTiltAngle = hourHandTiltAngel)
        }

    }
}