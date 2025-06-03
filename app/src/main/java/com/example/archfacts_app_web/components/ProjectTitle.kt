package com.example.archfacts_app_web.components

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit

@Composable
fun ProjectTitle(title: String, color: Color, fontSize : TextUnit = 32.sp, modifier: Modifier = Modifier ) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = fontSize,
        color = color,
        modifier = modifier
    )
}