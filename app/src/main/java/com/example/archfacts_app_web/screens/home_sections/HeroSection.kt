package com.example.archfacts_app_web.screens.home_sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.HeroBanner
import com.example.archfacts_app_web.components.HeroDownBar
import com.example.archfacts_app_web.components.Navbar
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.ArchOrange

@Composable
fun HeroSection(navActions: NavActions) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.archfacts),
            contentDescription = "Imagem de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.75f))
        )


        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Navbar(navActions = navActions)

            Column(modifier = Modifier.weight(1f)) {

                Spacer(modifier = Modifier.weight(0.5f))

                HeroBanner(modifier = Modifier.padding(15.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomButton(
                        "Saiba mais",
                        { println("Clicou") },
                        165.dp,
                        35.dp,
                    )

                    CustomButton(
                        "Cadastre-se",
                        {
                            println("Navegando para registro com controller: ${navActions}")
                            navActions.navigate(AppRoutes.Registro)
                        },
                        165.dp,
                        35.dp,
                        ArchOrange,
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            HeroDownBar()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HeroSectionPreview() {
    ArchFactsAppWebTheme {
        HeroSection(navActions = NavActions(rememberNavController()))
    }
}