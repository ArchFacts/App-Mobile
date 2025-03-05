package com.example.archfacts_app_web.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun Navbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(ArchBlack)
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        Row (verticalAlignment = Alignment.CenterVertically) {
            // Logos
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Principal ArchFacts",
                modifier = Modifier.size(50.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_af),
                contentDescription = "Logo com letras 'AF' ArchFacts",
                modifier = Modifier.size(70.dp),
            )
        }

        Row {
            Text(
                text = "Login",
                fontFamily = Poppins,
                fontWeight = FontWeight.Black,
                color = Color.White
            )

            Spacer(
                modifier = modifier.width(20.dp)
            )

            Text(
                text = "Cadastro",
                fontFamily = Poppins,
                fontWeight = FontWeight.Black,
                color = Color.White
            )
        }

        HamburguerMenuPreview()

    }
}

@Preview(showBackground = true)
@Composable
fun NavbarPreview() {
    ArchFactsAppWebTheme {
        Navbar()
    }
}