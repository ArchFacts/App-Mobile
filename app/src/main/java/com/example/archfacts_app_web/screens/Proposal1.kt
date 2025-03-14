package com.example.archfacts_app_web.screens.Proposal1

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.background
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
import com.example.archfacts_app_web.components.Navbar
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun EnvioPropostaScreen(negocioNome: String, logo: Int, mediaAvaliacoes: Int, servicosTotais: Int) {
    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.weight(0.4f))

        Text(
            text = "Envio de proposta",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Poppins,
            color = Color(0xFF0E0C19),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Você está prestes a enviar uma solicitação para $negocioNome",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            modifier = Modifier
                .padding(20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Confirme se essa é a empresa para a qual deseja enviar a proposta",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            modifier = Modifier
                .padding(18.dp)
        )

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = negocioNome,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Poppins,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Image(
            painter = painterResource(id = R.drawable.volks),
            contentDescription = "Logo da empresa",
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Média de avaliações: $mediaAvaliacoes",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = Poppins,
            color = if (mediaAvaliacoes >= 6) Color(0xFF00360A) else Color(0xFF600000),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Serviços totais prestados: $servicosTotais",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = Poppins,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.weight(0.3f))

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

        Spacer(modifier = Modifier.weight(0.5f))

        FooterProposal(activeIndex = 0, modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun EnvioPropostaPreview() {
    ArchFactsAppWebTheme {
        EnvioPropostaScreen(
            negocioNome = "Volkswagen",
            logo = R.drawable.archfacts,
            mediaAvaliacoes = 6,
            servicosTotais = 55
        )
    }
}