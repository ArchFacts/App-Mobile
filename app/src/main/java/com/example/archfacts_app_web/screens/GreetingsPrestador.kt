package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.NavAppPrestador
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.components.PerfilUsuario
import com.example.archfacts_app_web.components.ProfilePicture
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins
import kotlinx.coroutines.launch

data class PropostaItems(val solicitante: String, val servicosEscolhidos: String)

@Composable
fun Proposta(propostaItems: PropostaItems, navActions: NavActions) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(
                3.dp,
                clip = true,
                ambientColor = Color.Black.copy(alpha = 0.8f),
                spotColor = Color.Black.copy(alpha = 0.8f),
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp)),
        color = Color.White,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.height(100.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 25.dp),
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
                    append(propostaItems.solicitante)
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
                    Text(text = propostaItems.servicosEscolhidos)
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
                    tint = Color.White,
                    modifier = Modifier.clickable { navActions.navigate(AppRoutes.PropostaScreen) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingsPrestador(navActions: NavActions) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val windowInsets = WindowInsets.navigationBars.asPaddingValues()

    val propostas = listOf(
        PropostaItems("Júlia Campioto", "Carros estéticos, Carros esportivos"),
    )

    ModalNavigationDrawer(
        drawerContent = {
            NavAppPrestador(
                navActions = navActions,
                closeDrawer = { scope.launch { drawerState.close() } }
            )
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max)
                ) {
                    NavbarCorner { scope.launch { drawerState.open() } }
                    Text(
                        text = "Seja bem-vindo!",
                        fontFamily = Poppins,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = ArchBlue,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            content = { padding ->
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .padding(windowInsets)
                        .fillMaxSize()
                ) {
                    // Cabeçalho fixo
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        ProfilePicture(
                            painterResource(R.drawable.ecorp_logo),
                            133,
                            modifier = Modifier
                        )
                        Spacer(modifier = Modifier.size(12.dp))
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier
                                .fillMaxHeight()
                                .height(IntrinsicSize.Min)
                                .clip(RoundedCornerShape(12.dp))
                                .background(ArchBlack)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
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
                    // Bloco de propostas rolável
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        color = Color.White,
                    ) {
                        Column(Modifier.fillMaxSize()) {
                            Text(
                                text = "Propostas Abertas",
                                fontFamily = Poppins,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .background(ArchBlack)
                                    .fillMaxWidth()
                            )
                            LazyColumn(
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                                    .fillMaxSize()
                            ) {
                                items(propostas) { proposta ->
                                    Proposta(proposta, navActions)
                                    Spacer(modifier = Modifier.height(10.dp))
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}