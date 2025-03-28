package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.FormContainer
import com.example.archfacts_app_web.components.FormInput
import com.example.archfacts_app_web.components.NavbarVariation
import com.example.archfacts_app_web.screens.home_sections.Footer
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange

@Composable
fun RegisterBusiness(modifier: Modifier = Modifier) {
    val inputs: List<FormInput> = listOf(
        FormInput("Nome:", ""),
        FormInput("CPF/CNPJ:", ""),
        FormInput("CEP", ""),
        FormInput("Logradouro", ""),
        FormInput("Número", ""),
        FormInput("Bairro", ""),
        FormInput("Cidade", ""),
        FormInput("Estado", ""),

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
                    .background(Color.White)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center
            ) {
                FormContainer(
                    inputs,
                    RectangleShape,
                    title = "Cadastro da empresa",
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
fun RegisterBusinessPrev() {
    RegisterBusiness()
}