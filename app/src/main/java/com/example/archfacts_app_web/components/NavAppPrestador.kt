package com.example.archfacts_app_web.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.ui.theme.ArchBlack

@Composable
fun NavAppPrestador(modifier: Modifier = Modifier) {
    val navItems = listOf(
        NavItem(R.drawable.house, "Home"),
        NavItem(R.drawable.pasta, "Projetos"),
        NavItem(R.drawable.calendar, "Eventos"),
        NavItem(R.drawable.clipboard, "Tarefas"),
        NavItem(R.drawable.sign, "Dashboard"),
        NavItem(R.drawable.person, "Perfil")
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
fun NavAppPrestadorPreview() {
    NavAppPrestador()
}