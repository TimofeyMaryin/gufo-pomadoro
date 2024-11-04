package com.gufo.pomadoro.presentation.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gufo.pomadoro.ui.theme.primary
import com.gufo.pomadoro.ui.theme.surface
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun ClockScreen(hourHandTiltAngle: Float) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Найдем центр Canvas
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = size.minDimension / 2.5f // Размер часов

            // Нарисуем циферблат
            drawCircle(
                color = primary,
                radius = radius,
                center = Offset(centerX, centerY)
            )

            // Угол часовой стрелки от 12 часов (в градусах)
            val angle = hourHandTiltAngle

            // Длина часовой стрелки (короче, чем радиус циферблата)
            val hourHandLength = radius * 1.2f

            // Координаты конца часовой стрелки
            val endX = centerX + hourHandLength * cos(Math.toRadians(angle.toDouble())).toFloat()
            val endY = centerY + hourHandLength * sin(Math.toRadians(angle.toDouble())).toFloat()

            // Нарисуем часовую стрелку
            drawLine(
                color = surface,
                start = Offset(centerX, centerY),
                end = Offset(endX, endY),
                strokeWidth = 8.dp.toPx() // Толщина стрелки
            )

            drawCircle(
                color = surface,
                radius = 20f,
            )
        }
    }
}


@Preview
@Composable
fun HourHandLinePreview() {
    ClockScreen(45f)
}