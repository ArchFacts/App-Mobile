package com.example.archfacts_app_web.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.ui.theme.ArchBlue

@Composable
fun ProjectTitle(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        color = ArchBlue
    )
}

@Preview
@Composable
fun PreviewTitle(){
    ProjectTitle(
        title = "Projeto ECORP"
    )
}