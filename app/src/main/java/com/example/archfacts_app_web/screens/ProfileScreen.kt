package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.NavbarVariation
import com.example.archfacts_app_web.components.ProfileSlider
import com.example.archfacts_app_web.components.SlideContent
import com.example.archfacts_app_web.screens.home_sections.Footer
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun ProfileScreen() {
    val slides = listOf(
        SlideContent(
            image = R.drawable.beneficiario,
            text = "Sou um beneficiário"
        ),
        SlideContent(
            image = R.drawable.prestador,
            text = "Sou um prestador"
        ),
        SlideContent(
            image = R.drawable.funcionario,
            text = "Sou um funcionário"
        )
    )

    val pagerState = rememberPagerState(0, 0f) { slides.size }

    val texts = listOf(
        "Interessado em um dos nossos parceiros?",
        "Quer administrar seu negócio com a gente?",
        "Trabalha com um de nossos parceiros?"
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
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Escolha o seu perfil!",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Medium,
                    color = ArchBlue,
                    fontFamily = Poppins
                )

                Box(
                    modifier = Modifier
                        .background(ArchBlue, shape = RoundedCornerShape(16.dp))
                        .width(350.dp)
                ) {

                    Text(
                        text = texts[pagerState.currentPage],
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        fontFamily = Poppins,
                        textAlign = TextAlign.Center
                    )
                }


                ProfileSlider(slides, 350.dp, 550.dp, pagerState = pagerState)
            }
        },
        bottomBar = {
            Footer()
        }
    )
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}