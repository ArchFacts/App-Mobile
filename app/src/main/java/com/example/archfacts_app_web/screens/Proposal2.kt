package com.example.archfacts_app_web.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.FooterProposal
import com.example.archfacts_app_web.components.ServicesCard
import com.example.archfacts_app_web.components.ServicesCardPreview
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun Proposal2() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.weight(0.2f))

        Text(
            text = "Selecione os serviços",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Poppins,
            color = Color(0xFF0E0C19),
            textAlign = TextAlign.Center,
        )

//        Spacer(modifier = Modifier.weight(0.2f))

        Text(
            text = "Escolha os serviços de sua necessidade para prosseguir com a sua proposta",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            modifier = Modifier.padding(20.dp)
        )

//        Spacer(modifier = Modifier.height(5.dp))

        ServicesCardPreview()

        ServicesCardPreview()

//        Spacer(modifier = Modifier.weight(0.3f))

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomButton(
                "Voltar",
                { println("Clicou em Voltar") },
                165.dp,
                35.dp,
                Color(0xFF033E8C)
            )

            CustomButton(
                "Continuar",
                { println("Clicou em Continuar") },
                165.dp,
                35.dp,
                ArchOrange
            )
        }

        Spacer(modifier = Modifier.weight(0.2f))

        FooterProposal(activeIndex = 0, modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun Proposal2Preview() {
    Proposal2()
}