package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.archfacts_app_web.components.FormContainer
import com.example.archfacts_app_web.components.FormInput
import com.example.archfacts_app_web.components.NavbarVariation

@Composable
fun Register() {
    val inputs: List<FormInput> = listOf(
        FormInput("Nome:", ""),
        FormInput("Telefone:", ""),
        FormInput("Email:", ""),
        FormInput("Senha:", ""),
        FormInput("Confirmação de senha:", ""),
    )

    Column(modifier = Modifier.background(Color.White)) {
        NavbarVariation()

        Surface {
            FormContainer(inputs)
        }
        Footer()
    }
}

@Preview
@Composable
private fun RegisterPreview() {
    Register()
}