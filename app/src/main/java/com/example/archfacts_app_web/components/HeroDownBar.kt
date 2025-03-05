package com.example.archfacts_app_web.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.materialIcon
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
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlackTransparent
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun HeroItem(icon: Painter, text: String) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(ArchOrange, shape = CircleShape),
        )

        Spacer(modifier = Modifier.width(5.dp))

        Image(
            painter = icon,
            contentDescription = text,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}

@Composable
fun HeroDownBar() {
    val items = listOf(
        painterResource(id = R.drawable.gestao) to "Gestão",
        painterResource(id = R.drawable.handshake_icon) to "Parceria",
        painterResource(id = R.drawable.user_icon) to "Clientes"
    )

    Row(
        modifier = Modifier.fillMaxWidth()
            .background(ArchBlackTransparent),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        items.forEach { (icon, text) ->
            HeroItem(icon = icon, text = text)
        }
    }
}

@Preview
@Composable
fun HeroDownBarPreview() {
    HeroDownBar()
}