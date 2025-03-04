package com.example.archfacts_app_web.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.HeroBanner
import com.example.archfacts_app_web.components.Navbar
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.ArchOrange

@Composable
fun HeroSection() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.archfacts),
            contentDescription = "Imagem de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.7f)))
    }

    Column () {
        Navbar()

        Spacer(modifier = Modifier.height(100.dp))

        HeroBanner(modifier = Modifier.padding(15.dp))

        Row (modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            CustomButton("Saiba mais",
                { println("Clicou") },
                155.dp,
                35.dp)

            CustomButton("Cadastre-se",
                { println("Clicou") },
                155.dp,
                35.dp,
                ArchOrange,)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroSectionPreview() {
    ArchFactsAppWebTheme {
        HeroSection()
    }
}