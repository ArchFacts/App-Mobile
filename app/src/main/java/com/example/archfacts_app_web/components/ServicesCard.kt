package com.example.archfacts_app_web.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun ServicesCard(imageRes: Int, title: String, description: String, isSelected: Boolean) {
    Card(
        modifier = Modifier
            .padding(14.dp)
            .border(
                width = if (isSelected) 2.dp else 0.dp,
                color = if (isSelected) Color.Blue else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            ),
        elevation = CardDefaults.cardElevation(14.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold,
                color = Color.Black, fontFamily = Poppins)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, fontSize = 14.sp, fontWeight = FontWeight.Medium,
                color = Color.Black, fontFamily = Poppins)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicesCardPreview() {
    ServicesCard(
        imageRes = R.drawable.carro1,
        title = "Serviço de Manutenção",
        description = "Manutenção preventiva e corretiva para seu veículo.",
        isSelected = true
    )
}