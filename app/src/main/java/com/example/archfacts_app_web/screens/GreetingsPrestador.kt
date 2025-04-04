package com.example.archfacts_app_web.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.components.ProfilePicture
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

data class PrestadorItems(val solicitante: String, val servicosEscolhidos: String)

@Composable
fun Propostas() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(
                12.dp,
                clip = true,
                ambientColor = Color.Black.copy(alpha = 0.8f),
                spotColor = Color.Black.copy(alpha = 0.8f)
            ),
        color = Color.White,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.height(100.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxHeight().padding(horizontal = 25.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontFamily = Poppins,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = ArchBlue
                        )
                    ) {
                        append("Solicitante: ")
                    }
                    append("Júlia Campioto")
                })
                Column {
                    Text(
                        text = "Serviços escolhidos: ",
                        fontFamily = Poppins,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = ArchBlue,
                        textAlign = TextAlign.Center,
                    )
                    Text(text = "Carros estéticos, Carros esportivos")
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(ArchBlue)
                    .fillMaxHeight()
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Ícone de seta",
                    tint = Color.White
                )
            }
        }
    }
}


@Composable
fun GreetingsPrestador() {
    Scaffold(topBar = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            NavbarCorner()
            Text(
                text = "Seja bem-vindo!",
                fontFamily = Poppins,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                color = ArchBlue,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }, content = { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ProfilePicture(
                    painterResource(R.drawable.ecorp_logo),
                    150,
                    modifier = Modifier
                )

                Spacer(modifier = Modifier.size(12.dp))

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .height(IntrinsicSize.Min)
                        .clip(RoundedCornerShape(12.dp))
                        .background(ArchBlack)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "E-corp",
                            fontFamily = Poppins,
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                        Text(
                            text = buildAnnotatedString {
                                append("Avaliação: ")
                                withStyle(style = SpanStyle(color = ArchOrange)) {
                                    append("5")
                                }
                            },
                            fontFamily = Poppins,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .shadow(
                        12.dp,
                        RoundedCornerShape(15.dp),
                        clip = true,
                        ambientColor = Color.Black.copy(alpha = 0.8f),
                        spotColor = Color.Black.copy(alpha = 0.8f)
                    ),
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(ArchBlack)
                ) {
                    Text(
                        text = "Propostas Abertas",
                        fontFamily = Poppins,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                    )
                }
                LazyColumn {

                }
            }
        }

    }, bottomBar = {

    })
}

@Preview
@Composable
fun GreetingsPrestadorPreview() {
    Propostas()
}