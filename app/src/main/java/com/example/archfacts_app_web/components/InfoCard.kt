package com.example.archfacts_app_web.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.Poppins
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import com.example.archfacts_app_web.ui.theme.ArchOrange

sealed class InfoCardStyle(val backgroundColor: Color) {
    data object Azul : InfoCardStyle(ArchBlue)
    data object Laranja : InfoCardStyle(ArchOrange)
    data class Custom(val color: Color) : InfoCardStyle(color)
}


@Composable
fun InfoCard(
    text: String,
    qtd: Int,
    qtdProgresso: Int,
    qtdFechado: Any,
    modifier: Modifier = Modifier,
    style: InfoCardStyle = InfoCardStyle.Azul
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(Color.White)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
    )
    {
        Box(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(16.dp))
                .background(style.backgroundColor)
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = qtd.toString(),
                    color = Color.White,
                    fontSize = 48.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(style.backgroundColor)
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "Em progresso:",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = qtdProgresso.toString(),
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                    )

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(style.backgroundColor)
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Fechado:",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = qtdFechado.toString(),
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewInfoCard() {
    InfoCard(
        text = "Chamados:",
        qtd = 33,
        qtdProgresso = 16,
        qtdFechado = 16,
    )
}