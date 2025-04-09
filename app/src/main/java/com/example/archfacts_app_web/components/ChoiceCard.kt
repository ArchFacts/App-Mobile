package com.example.archfacts_app_web.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

sealed class CardType(
    val iconRes: Int,
    val backgroundColor: Color,
    val iconColor: Color
) {
    data object Chamados : CardType(
        iconRes = R.drawable.person,
        backgroundColor = ArchBlue,
        iconColor = Color.White
    )

    data object Tarefas : CardType(
        iconRes = R.drawable.clipboard,
        backgroundColor = ArchOrange,
        iconColor = Color.White
    )
}

@Composable
fun ChoiceCard(type: CardType, number: Int) {
    Box(
        modifier = Modifier
            .width(175.dp)
            .height(175.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(type.backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = type.iconRes),
                contentDescription = when (type) {
                    is CardType.Chamados -> "Icone de chamados"
                    is CardType.Tarefas -> "Icone de tarefas"
                },
                tint = type.iconColor,
                modifier = Modifier.size(100.dp),
            )
            Text(
                text = when (type) {
                    CardType.Chamados -> "Chamados"
                    CardType.Tarefas -> "Tarefas"
                },
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                color = Color.White
            )
            Text(
                text = number.toString(),
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ChoiceCardPreview() {
    ChoiceCard(CardType.Chamados, 33)
}