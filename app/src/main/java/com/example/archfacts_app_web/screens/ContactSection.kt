package com.example.archfacts_app_web.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.DescStyle
import com.example.archfacts_app_web.components.TitleDescContainer
import com.example.archfacts_app_web.components.TitleStyle

@Composable
fun ContactSection() {
    Column {
        TitleDescContainer(
            200.dp, "Entre em contato", "Caso tenha dúvidas," +
                    " preencha o formulário e entre em contato conosco!", titleStyle = TitleStyle(
                fontSize = 24.sp, fontWeight = FontWeight.Bold
            ),
            descStyle = DescStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactSectionPreview() {
    ContactSection()
}