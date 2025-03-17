package com.example.archfacts_app_web.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun BulletPointList(
    items: List<String>,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 12.sp
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        items.forEach { item ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(3.dp)
                        .background(Color.White, shape = CircleShape),
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = item,
                    color = Color.White,
                    fontFamily = Poppins,
                    fontSize = fontSize
                )
            }
        }
    }
}

@Composable
fun RoleCard(
    image: Painter, title: String, subtitle: String,
    bulletPoints: List<String>
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
            )
    ) {
        Box {
            Column(modifier = Modifier.background(ArchBlack)) {
                Image(
                    painter = image,
                    contentDescription = "Imagem representativa das roles na plataforma",
                )

                Column(modifier = Modifier.padding(15.dp)) {
                    Text(
                        text = title,
                        color = ArchOrange,
                        fontSize = 20.sp,
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = subtitle,
                        color = Color.White,
                        fontSize = 14.sp,

                        )

                    Spacer(modifier = Modifier.height(5.dp))

                    BulletPointList(bulletPoints)
                }
            }
        }
    }
}

@Preview()
@Composable
fun RoleCardPreview() {
    RoleCard(
        painterResource(id = R.drawable.prestador_home),
        "Prestador de serviço",
        "Acesso ao serviço de gestão de negócio como administrador", bulletPoints = listOf
            (
            "Gerenciamento de negócio;",
            "Página exclusiva para seus clientes;",
            "Trabalho em conjunto com seu empregado;",
            "Insights sobre o seu negócio."
        )
    )
}