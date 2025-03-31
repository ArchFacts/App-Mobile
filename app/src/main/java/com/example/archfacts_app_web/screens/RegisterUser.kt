package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.FormContainer
import com.example.archfacts_app_web.components.FormInput
import com.example.archfacts_app_web.components.NavbarVariation
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.screens.home_sections.Footer
import com.example.archfacts_app_web.ui.theme.ArchBlue

@Composable
fun RegisterUser(navActions: NavActions) {
    val inputs: List<FormInput> = listOf(
        FormInput("Nome:", ""),
        FormInput("Telefone:", ""),
        FormInput("Email:", ""),
        FormInput("Senha:", "", true),
        FormInput("Confirmação de senha:", "", true),
    )

    Scaffold(
        topBar = {
            NavbarVariation()
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center
            ) {
                FormContainer(
                    inputs,
                    RectangleShape,
                    title = "Cadasto",
                    mostrarSeta = true,
                    button = {
                        CustomButton(
                            text = "Cadastrar",
                            onClick = { },
                            width = 200.dp,
                            height = 35.dp,
                            backgroundColor = ArchBlue,
                        )
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        },
        bottomBar = {
            Footer()
        }
    )
}

@Preview
@Composable
private fun RegisterPreview() {
    RegisterUser(navActions = NavActions(rememberNavController()))
}