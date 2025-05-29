package com.example.archfacts_app_web.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Evento(
    val titulo: String,
    val descricao: String,
    val dataCriacao: String,
    val dataEncerramento: String,
    val status: String,
    val tipo: String,
    val tempoRestante: String
)

@Composable
fun EventoCard(evento: Evento) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .padding(horizontal = 8.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = evento.titulo,
                fontSize = 18.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Tipo: ${evento.tipo}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Descrição: ${evento.descricao}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Data de criação: \n${evento.dataCriacao}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Data de encerramento: ${evento.dataEncerramento}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = evento.tempoRestante)
            Spacer(modifier = Modifier.height(12.dp))
            CustomButton(
                text = evento.status,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventoCardPreview() {
    EventoCard(
        evento = Evento(
            titulo = "Abelhas",
            descricao = "limpeza com produtos.",
            dataCriacao = "07/03/2026",
            dataEncerramento = "07/03/2026",
            status = "Não iniciado",
            tipo = "Serviço",
            tempoRestante = "3 dias, 5 horas e 33 minutos restantes para encerramento"
        )
    )
}