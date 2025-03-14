package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.DetailCard
import com.example.archfacts_app_web.components.HamburguerMenu
import com.example.archfacts_app_web.components.ProjectTitle
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

@Preview
@Composable
fun ProjectDetails() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Box {
            Column(
                modifier = Modifier
                    .border(80.dp, ArchBlack, RoundedCornerShape(8.dp))
                    .padding(10.dp)
                    .width(80.dp)
                    .height(50.dp)
            ) {
            }
            HamburguerMenu(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(y = (-16).dp)
                    .padding(25.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            ProjectTitle(title = "Projeto ECORP")
        }
        Spacer(modifier = Modifier
            .padding(10.dp))
        DetailCard(
            title = "Projeto de Abelha",
            status = "Em progresso",
            startDate = "07/03/2025",
            endDate = "07/03/2025",
            buttonText = "Finalizar",
            onButtonClick = { }
        )
    }
}