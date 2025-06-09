package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.CardType
import com.example.archfacts_app_web.components.ChoiceCard
import com.example.archfacts_app_web.components.NavAppPrestador
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.Poppins
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChoiceScreen(navActions: NavActions) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val windowInsets = WindowInsets.navigationBars.asPaddingValues()

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
                NavbarCorner { scope.launch { drawerState.open() } }
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(windowInsets)
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = ArchBlack,
                                shape = RoundedCornerShape(
                                    bottomStart = 100.dp,
                                    bottomEnd = 100.dp,
                                )
                            )
                            .fillMaxWidth()
                            .fillMaxHeight(0.55f)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "PROJETOS ECORP",
                                fontFamily = Poppins,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                                fontSize = 28.sp
                            )
                            Text(
                                "Projeto de abelhas", fontFamily = Poppins,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                                fontSize = 32.sp,
                                modifier = Modifier.width(250.dp)
                            )
                            Text(
                                "Júlia Campioto", fontFamily = Poppins,
                                fontWeight = FontWeight.Normal,
                                color = Color.White,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center, fontSize = 25.sp
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            "O que você quer ver?",
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                            fontFamily = Poppins,
                            fontSize = 32.sp,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            ChoiceCard(
                                CardType.Chamados,
                                27,
                                onClick = { navActions.navigate(AppRoutes.ProjectDetailsChamados) }
                            )
                            ChoiceCard(
                                CardType.Tarefas,
                                30,
                                onClick = { navActions.navigate(AppRoutes.ProjectDetailsTarefas) }
                            )
                        }
                    }
                }
            }
        )
    }
}