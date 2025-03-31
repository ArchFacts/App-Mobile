package com.example.archfacts_app_web.components

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier

@Composable
fun ProjectTitle(title: String, color: Color, modifier: Modifier = Modifier ) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        color = color,
        modifier = modifier
    )
}