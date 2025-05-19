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
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.screens.home_sections.Footer
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange

@Composable
fun Login(modifier: Modifier = Modifier, navActions: NavActions) {
    val inputs: List<FormInput> = listOf(
        FormInput("Email:", ""),
        FormInput("Senha", "", isPassword = true),
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
                    title = "Login",
                    mostrarSeta = true,
                    cliqueSeta = { navActions.navigate(AppRoutes.Home) },
                    button = {
                        CustomButton(
                            text = "Login",
                            onClick = { },
                            width = 200.dp,
                            height = 35.dp,
                            backgroundColor = ArchOrange,
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

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login(navActions = NavActions(rememberNavController()))
}