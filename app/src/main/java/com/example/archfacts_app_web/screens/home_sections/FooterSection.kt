package com.example.archfacts_app_web.screens.home_sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.BulletPointList
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun Footer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(ArchBlack).height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "© 2025 ArchFacts all rights reserved.",
            color = Color.White,
            fontFamily = Poppins,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun IconText(icon: Painter) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = "icone das redes sociais",
            modifier = Modifier
                .padding(end = 8.dp)
                .size(24.dp)
        )
        Text(text = "ArchFacts", fontSize = 20.sp, color = Color.White)
    }
}

@Composable
fun FooterSection() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ArchBlack)
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo ArchFacts",
            modifier = Modifier.fillMaxSize(),
            alpha = 0.2f
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(30.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.height(200.dp), verticalArrangement = Arrangement.SpaceAround) {
                Text(
                    text = "Navegue:",
                    fontSize = 36.sp,
                    color = ArchOrange,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium
                )
                BulletPointList(
                    listOf(
                        "Home",
                        "Problemas resolvidos",
                        "Por quê usar nossa solução?",
                        "Conheça os perfis"
                    ), fontSize = 20.sp
                )
            }
            Column(Modifier.height(200.dp), verticalArrangement = Arrangement.SpaceAround) {
                Text(
                    text = "Redes Sociais:",
                    fontSize = 36.sp,
                    color = ArchOrange,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium
                )
                IconText(icon = painterResource(id = R.drawable.linkedin_icon))
                IconText(icon = painterResource(id = R.drawable.instagram_icon))
                IconText(icon = painterResource(id = R.drawable.facebook_icon))
            }
            Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
                CustomButton("Cadastre-se", { }, 150.dp, 30.dp, ArchOrange, 20.sp)
                CustomButton("Login", { }, 150.dp, 30.dp, ArchBlue, 20.sp)
            }

            Footer()

        }
    }
}


@Preview(showBackground = true)
@Composable
fun FooterSectionPreview() {
    Footer()
}