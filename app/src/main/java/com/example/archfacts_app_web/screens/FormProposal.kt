package com.example.archfacts_app_web.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.FooterProposal
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun FormProposal() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.weight(0.2f))

        Text(
            text = "Formulário de Proposta",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Poppins,
            color = Color(0xFF0E0C19),
            textAlign = TextAlign.Center,
        )

        Text(
            text = "Preencha os dados para que sua proposta seja analisada com agilidade",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        Spacer(modifier = Modifier.weight(0.1f))

        val fieldModifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 6.dp)

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Título:", fontWeight = FontWeight.Bold) },
            modifier = fieldModifier,
            colors = textFieldColors()
        )

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("CEP:", fontWeight = FontWeight.Bold) },
            modifier = fieldModifier,
            colors = textFieldColors()
        )

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Endereço:", fontWeight = FontWeight.Bold) },
            modifier = fieldModifier,
            colors = textFieldColors()
        )

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Número:", fontWeight = FontWeight.Bold) },
            modifier = fieldModifier,
            colors = textFieldColors()
        )

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Complemento:", fontWeight = FontWeight.Bold) },
            modifier = fieldModifier,
            colors = textFieldColors()
        )

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Data:", fontWeight = FontWeight.Bold) },
            modifier = fieldModifier,
            colors = textFieldColors()
        )

        // Campo "Descrição" com contorno
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Descrição:", fontWeight = FontWeight.Bold) },
            modifier = fieldModifier.height(100.dp)
        )

        Spacer(modifier = Modifier.weight(0.2f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomButton(
                "Voltar",
                { /* ação de voltar */ },
                165.dp,
                35.dp,
                Color(0xFF033E8C)
            )

            CustomButton(
                "Continuar",
                { /* ação de continuar */ },
                165.dp,
                35.dp,
                ArchOrange
            )
        }

        Spacer(modifier = Modifier.weight(0.2f))

        FooterProposal(activeIndex = 0, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun textFieldColors() = TextFieldDefaults.colors(
    unfocusedIndicatorColor = Color.Gray,
    focusedIndicatorColor = Color.Black,
    disabledIndicatorColor = Color.LightGray,
    unfocusedContainerColor = Color.Transparent,
    focusedContainerColor = Color.Transparent,
    disabledContainerColor = Color.Transparent
)

@Preview(showBackground = true)
@Composable
fun FormProposalPreview() {
    FormProposal()
}