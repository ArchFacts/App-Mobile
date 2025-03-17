package com.example.archfacts_app_web.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.ServicesCard
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.ServicesCardPreview
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun Proposal2() {
    val services = listOf(
        Service(R.drawable.carro1, "Serviço de Manutenção", "Manutenção preventiva e corretiva para seu veículo.", true),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Nossos Serviços",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontFamily = Poppins,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(services) { service ->
                ServicesCard(
                    imageRes = service.imageRes,
                    title = service.title,
                    description = service.description,
                    isSelected = service.isSelected
                )
            }
        }
    }
}

data class Service(
    val imageRes: Int,
    val title: String,
    val description: String,
    val isSelected: Boolean
)

@Preview(showBackground = true)
@Composable
fun Proposal2Preview() {
    ServicesCardPreview()
}