package com.example.archfacts_app_web.screens.home_sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.Slider
import com.example.archfacts_app_web.components.TitleDescContainer

@Composable
fun SolutionSection() {
    Box {
        val images = listOf(
            R.drawable.big_carousel1,
            R.drawable.aperto_mao,
            R.drawable.big_carousel2
        )

        Slider(images, 2500.dp, 900.dp, modifier = Modifier.fillMaxSize())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleDescContainer(
            title = "Tenha uma organização interativa",
            desc = "Através de nossa plataforma de gerenciamento, torne a construção do projeto do seu" +
                    " serviço oferecido mais flexível e mais adequada ao seu cliente trabalhando" +
                    " diretamente com ele para atender a sua necessidade!",
        )

        CustomButton("Se interessou? Clique aqui", {}, width = 300.dp)
    }
}

@Preview
@Composable
fun SolutionSectionPreview() {
    SolutionSection()
}