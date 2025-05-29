package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.Evento
import com.example.archfacts_app_web.components.EventoCard
import com.example.archfacts_app_web.components.HamburguerMenu
import androidx.compose.foundation.lazy.items
import com.example.archfacts_app_web.components.ProjectTitle

@Composable
fun EventosScreen(eventos: List<Evento>) {
    val query = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HamburguerMenu()
        ProjectTitle(title = "Eventos", color = Color.Black, fontSize = 20.sp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

        }

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

@Preview(showBackground = true)
@Composable
fun EventosScreenPreview() {
    val mockEventos = listOf(
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

    EventosScreen(eventos = mockEventos)
}