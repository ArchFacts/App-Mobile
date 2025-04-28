package com.example.archfacts_app_web.enums

import androidx.compose.ui.graphics.Color

enum class PriorityEnum(val prioridadeStatus: String, val color: Color) {
    ALTA("Alta", Color.Red),
    MEDIA("Média", Color.Yellow),
    BAIXA("Baixa", Color.Green)
}