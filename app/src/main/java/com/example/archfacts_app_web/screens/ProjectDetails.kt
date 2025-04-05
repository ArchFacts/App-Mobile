package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.components.DetailCard
import com.example.archfacts_app_web.components.HamburguerMenu
import com.example.archfacts_app_web.components.InfoCard
import com.example.archfacts_app_web.components.ProjectTitle
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue

@Preview
@Composable
fun ProjectDetails() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
            HamburguerMenu(modifier = Modifier)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            ProjectTitle(title = "Projeto ECORP" , color = ArchBlack, modifier = Modifier)
        }
        Spacer(modifier = Modifier
            .padding(10.dp))
        DetailCard(
            title = "Projeto de Abelha",
            status = "Em progresso",
            startDate = "07/03/2025",
            endDate = "07/03/2025",
            buttonText = "Finalizar",
            onButtonClick = { },
            modifier = Modifier.border(10.dp, color = Color.Gray
            )
        )
        Spacer(modifier = Modifier
            .padding(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProjectTitle(title = "Chamados Info", color = ArchBlack, modifier = Modifier)
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Usuário",
                tint = ArchBlue,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier
            .padding(10.dp))
        InfoCard(
            text = "Chamados:",
            qtd = 33,
            qtdProgresso = 16,
            qtdFechado = 16,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
    }