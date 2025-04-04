package com.example.archfacts_app_web.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun NavLine(icon: Painter, text: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Row (verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = icon,
                tint = ArchOrange,
                contentDescription = "Ícone da Navbar",
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = text,
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                fontFamily = Poppins,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            )
        }
        HorizontalDivider(color = ArchOrange, thickness = 3.dp)
    }
}

data class NavItem(val iconRes: Int, val text: String)

@Composable
fun NavAppBeneficiario(modifier: Modifier = Modifier) {
    val navItems = listOf(
        NavItem(R.drawable.house, "Home"),
        NavItem(R.drawable.clipboard, "Projetos"),
        NavItem(R.drawable.aperto, "Empresas"),
        NavItem(R.drawable.person, "Parceiras")
    )

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(ArchBlack)
            .fillMaxSize()
            .padding(horizontal = 36.dp)
    ) {
        navItems.forEach { item ->
            NavLine(
                icon = painterResource(id = item.iconRes),
                text = item.text
            )
        }
    }
}

@Preview
@Composable
fun NavAppBeneficiarioPreview() {
    NavAppBeneficiario()
}