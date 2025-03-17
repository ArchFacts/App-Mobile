package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.RoleCard

@Composable
fun RoleSection(modifier: Modifier = Modifier) {
    Column( modifier = Modifier.fillMaxSize().background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RoleCard(
            painterResource(id = R.drawable.prestador_home),
            "Prestador de serviço",
            "Acesso ao serviço de gestão de negócio como administrador", bulletPoints = listOf
                (
                "Gerenciamento de negócio;",
                "Página exclusiva para seus clientes;",
                "Trabalho em conjunto com seu empregado;",
                "Insights sobre o seu negócio."
            )
        )
    }
}

@Preview
@Composable
private fun RoleSectionPreview() {
    RoleSection()
}