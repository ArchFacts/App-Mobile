package com.example.archfacts_app_web.screens

import android.R.style
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentPaste
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.DetailCard
import com.example.archfacts_app_web.components.DetailCardType
import com.example.archfacts_app_web.components.HamburguerMenu
import com.example.archfacts_app_web.components.InfoCard
import com.example.archfacts_app_web.components.InfoCardStyle
import com.example.archfacts_app_web.components.NavigationButton
import com.example.archfacts_app_web.components.NavigationButtonStyle
import com.example.archfacts_app_web.components.ProjectTitle
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange

@Preview
@Composable
fun ProjectDetailsChamados() {
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
            ProjectTitle(title = "Projetos ECORP" , color = ArchBlack,
                fontSize = 32.sp, modifier = Modifier)
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .shadow(6.dp, RoundedCornerShape(16.dp))
                .background(Color.White, RoundedCornerShape(16.dp)),
//            cardType = DetailCardType.SemBotao
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
            ProjectTitle(title = "Chamados Info", color = ArchBlack,
                fontSize = 32.sp,   modifier = Modifier)
            Icon(
                imageVector = Icons.Filled.ContentPaste,
                contentDescription = "Tarefas",
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
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .shadow(6.dp, RoundedCornerShape(16.dp))
                .background(Color.White, RoundedCornerShape(16.dp)),
            style = InfoCardStyle.Azul
        )
        Spacer(modifier = Modifier
            .padding(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            NavigationButton(
                text = "Ir para chamados",
                modifier = Modifier,
                onClick = { },
                style = NavigationButtonStyle.Azul
            )
        }

    }
}