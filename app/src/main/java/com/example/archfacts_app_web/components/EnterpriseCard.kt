package com.example.archfacts_app_web.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.ui.theme.Poppins

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnterpriseCard()
        }
    }
}

@Composable
fun EnterpriseCard(
    companyName: String = "ECORP",
    cardWidth: Dp = Dp.Unspecified,
    cardHeight: Dp = 120.dp,
    companyImage: Int = R.drawable.ecorp_logo,
    registrationDate: String = "07/03/2005"
) {
    var arrowColor = Color(0xFF033E8C)
    var isStarMarked by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight)
            .width(cardWidth)
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = companyImage),
                contentDescription = "$companyName Logo",
                modifier = Modifier
                    .size(110.dp)
                    .clip(RoundedCornerShape(5.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            )
            {
                Text(
                    text = companyName, // Nome da empresa (parâmetro)
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontFamily = Poppins
                    )
                )
                Text(
                    text = "Data de Registro:",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = Poppins
                    ),
                )
                Text(
                    text = registrationDate, // Data de registro (parâmetro)
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = Poppins
                    ),
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(5) { index ->
                        StarComponent(
                            isMarked = true,
                            onToggle = { isStarMarked = !isStarMarked }
                        )
                        if (index < 4) {
                            Spacer(modifier = Modifier.width(4.dp)) // Espaço entre as estrelas
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(arrowColor)
                    .width(42.dp)
                    .padding(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Ícone de seta",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}

@Composable
fun StarComponent(
    isMarked: Boolean,
    onToggle: () -> Unit
) {

    val orangeColor = Color(0xFFFFA500) // HEX para laranja
    val starColor = if (isMarked) orangeColor else Color.White

    Icon(
        painter = painterResource(id = R.drawable.baseline_star_24), // Ícone de estrela
        contentDescription = if (isMarked) "Estrela Marcada" else "Estrela Desmarcada",
        tint = starColor,
        modifier = Modifier
            .size(24.dp)
            .clickable { onToggle() }
    )
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    EnterpriseCard()
}