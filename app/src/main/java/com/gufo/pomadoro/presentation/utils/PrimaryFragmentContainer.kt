package com.gufo.pomadoro.presentation.utils

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun PrimaryFragmentContainer(
    @StringRes title: Int,
    content: @Composable () -> Unit,
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(.95f)
                .fillMaxHeight(.9f)
        ) {


            Container(weight = 1f, alignment = Alignment.TopStart) {
                AppText(
                    value = stringResource(id = title),
                    textSize = TextSize.LARGE,
                    fontWeight = FWeight.BOLD,
                    color = Color.Unspecified
                )
            }

            Container(weight = 8f) {
                content()
            }

        }

    }

}