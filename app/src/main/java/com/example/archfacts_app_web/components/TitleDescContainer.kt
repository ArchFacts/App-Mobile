package com.example.archfacts_app_web.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.ui.theme.Poppins

data class TitleStyle(
    val fontSize: TextUnit = 24.sp,
    val color: Color = Color.Black,
    val fontFamily: FontFamily = Poppins,
    val fontWeight: FontWeight = FontWeight.Normal
)

data class DescStyle(
    val fontSize: TextUnit = 16.sp,
    val color: Color = Color.Black,
    val fontFamily: FontFamily = Poppins,
    val fontWeight: FontWeight = FontWeight.Light
)

@Composable
fun TitleDescContainer(
    height: Dp = 300.dp,
    title: String,
    desc: String,
    background: Color = Color.White,
    titleStyle: TitleStyle = TitleStyle(),
    descStyle: DescStyle = DescStyle(),
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .shadow(
                12.dp,
                RoundedCornerShape(15.dp),
                clip = true,
                ambientColor = Color.Black.copy(alpha = 0.25f),
                spotColor = Color.Black.copy(alpha = 0.25f)
            ),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
    ) {
        Column(
            modifier = Modifier
                .height(height)
                .background(background)
                .padding(25.dp)
        ) {
            Text(
                text = title,
                fontSize = titleStyle.fontSize,
                color = titleStyle.color,
                fontFamily = titleStyle.fontFamily,
                fontWeight = titleStyle.fontWeight,
            )

            Text(
                text = desc,
                fontSize = descStyle.fontSize,
                color = descStyle.color,
                fontFamily = descStyle.fontFamily,
                fontWeight = descStyle.fontWeight
            )
        }
    }
}

@Preview
@Composable
fun PreviewTitleDescContainer() {
    TitleDescContainer(
        title = "Tenha uma organização interativa",
        desc = "Através de nossa plataforma de gerenciamento, torne a construção do projeto do seu" +
                " serviço oferecido mais flexível e mais adequada ao seu cliente trabalhando" +
                " diretamente com ele para atender a sua necessidade!",
    )
}