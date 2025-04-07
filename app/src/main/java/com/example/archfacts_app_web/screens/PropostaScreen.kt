package com.example.archfacts_app_web.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.FormItem
import com.example.archfacts_app_web.components.FormLine
import com.example.archfacts_app_web.components.FormsApp
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun PropostaScreen(modifier: Modifier = Modifier) {
    val formItems = listOf(
        FormItem("E-mail do solicitante", "julia@gmail.com", false),
        FormItem("Serviços Escolhidos:", "Carros Estéticos, Carros econômicos", false),
        FormItem("Data de entrega do projeto:", "07/03/2026", false),
        FormItem(
            "Descrição adicional:",
            "O carro estético deve ter um sistema de iluminação LED diferenciado.",
            false
        )
    )
    Scaffold(topBar = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            NavbarCorner()
            Text(
                text = "Proposta de Júlia",
                fontFamily = Poppins,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                color = ArchBlue,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }, content = { innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            FormsApp(formItems)
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomButton(
                    "Recusar",
                    width = 175.dp,
                    height = 50.dp,
                    backgroundColor = ArchOrange,
                    fontSize = 16.sp,
                    onClick = {})
                CustomButton("Aceitar",
                    width = 175.dp,
                    height = 50.dp,
                    backgroundColor = ArchBlue,
                    fontSize = 16.sp,
                    onClick = {})
            }
        }
    }, bottomBar = {

    })
}

@Preview
@Composable
private fun PropostaScreenPreview() {
    PropostaScreen()
}