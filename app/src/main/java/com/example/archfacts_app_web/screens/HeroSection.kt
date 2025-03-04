package com.example.archfacts_app_web.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.HeroBanner
import com.example.archfacts_app_web.components.Navbar
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme

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
    }

}

@Preview(showBackground = true)
@Composable
fun HeroSectionPreview() {
    ArchFactsAppWebTheme {
        HeroSection()
    }
}