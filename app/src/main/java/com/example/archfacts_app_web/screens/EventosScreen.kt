package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.*
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.ui.theme.ArchBlack
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventosScreen(navActions: NavActions) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val windowInsets = WindowInsets.navigationBars.asPaddingValues()
    val query = remember { mutableStateOf("") }

    // Mock de eventos
    val eventos = remember {
        listOf(
            Evento(
                titulo = "Abelhas",
                tipo = "Projeto",
                descricao = "Limpeza com produtos.",
                dataCriacao = "07/03/2026",
                dataEncerramento = "07/03/2026",
                tempoRestante = "3 dias, 5 horas e 33 minutos restantes para encerramento",
                status = "Não iniciado"
            ),
            Evento(
                titulo = "Formigas",
                tipo = "Projeto",
                descricao = "Controle em áreas verdes.",
                dataCriacao = "07/03/2026",
                dataEncerramento = "07/03/2026",
                tempoRestante = "2 dias, 3 horas restantes",
                status = "Em Progresso"
            )
        )
    }

    ModalNavigationDrawer(
        drawerContent = {
            NavAppPrestador(
                navActions = navActions,
                closeDrawer = { scope.launch { drawerState.close() } }
            )
        },
        drawerState = drawerState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(windowInsets)
        ) {
            NavbarCorner { scope.launch { drawerState.open() } }
            ProjectTitle(title = "Eventos", color = ArchBlack, fontSize = 20.sp)
            SearchBar(
                query = query.value,
                onQueryChange = { query.value = it },
                onSearch = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                items(eventos.filter { it.titulo.contains(query.value, ignoreCase = true) }) { evento ->
                    EventoCard(evento = evento)
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun EventosScreenPreview() {
//    val fakeNavActions = object : NavActions(navController = androidx.navigation.compose.rememberNavController()) {}
//    EventosScreen(navActions = fakeNavActions)
//}