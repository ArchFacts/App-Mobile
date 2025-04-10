package com.example.archfacts_app_web.enums

import androidx.compose.ui.graphics.Color

enum class RequestEnum(val requestStatus: String, val color: Color) {
    NAO_FINALIZADO("Não Finalizado", Color.Red),
    EM_PROGRESSO("Em progresso", Color.Yellow),
    FINALIZADO("Finalizado", Color.Green)
}