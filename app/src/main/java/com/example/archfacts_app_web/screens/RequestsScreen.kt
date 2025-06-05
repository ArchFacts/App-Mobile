package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.CardType
import com.example.archfacts_app_web.components.Counter
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.components.NavigationBar
import com.example.archfacts_app_web.enums.RequestEnum
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.Poppins
import com.example.archfacts_app_web.viewModel.RequestsViewModel

// ---------- TIPOS DE TELA ----------
sealed class RequestScreenType {
    object Chamados : RequestScreenType()
    object ChamadosBeneficiario : RequestScreenType()
    object Tarefas : RequestScreenType()
}

// ---------- DADOS MOCKADOS ----------
data class RequestData(
    val title: String,
    val dateEnd: String,
    val status: RequestEnum,
    val type: CardType,
    val project: String = "",
)

@Composable
fun AddButton(onClick: () -> Unit, color: Color) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "Adicionar")
    }
}

@Composable
fun RequestItem(request: RequestData) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
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
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
                .height(40.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .background(request.status.color)
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = request.status.name,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins,
                fontSize = 12.sp
            )

            Spacer(Modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.clipboard),
                contentDescription = "Icone de prancheta",
                tint = ArchBlack,
                modifier = Modifier.size(22.dp)
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = request.title,
                fontWeight = FontWeight.Medium,
                fontFamily = Poppins,
                maxLines = 2,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(55.dp),
            )

            Spacer(Modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.calendar),
                contentDescription = "Icone de calendário",
                tint = ArchBlack,
                modifier = Modifier.size(22.dp)
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = request.dateEnd,
                fontWeight = FontWeight.Medium,
                fontFamily = Poppins,
            )

            Spacer(Modifier.weight(1f))

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(request.type.backgroundColor)
                    .fillMaxHeight()
            ) {
//                Icon(
//                    painterResource(id = R.drawable.ic_add), // ou PlayArrow, conforme preferir
//                    contentDescription = "Ícone de ação",
//                    tint = Color.White
//                )
            }
        }
    }
}

@Composable
fun RequestsScreen(
    screenType: RequestScreenType,
    viewModel: RequestsViewModel = viewModel()
) {
    var searchQuery by remember { mutableStateOf("") }
    val requests = viewModel.getRequests(
        when (screenType) {
            is RequestScreenType.Chamados, is RequestScreenType.ChamadosBeneficiario -> CardType.Chamados
            is RequestScreenType.Tarefas -> CardType.Tarefas
        }
    )

    // Parâmetros variáveis por tela
    val title = when (screenType) {
        is RequestScreenType.Chamados -> "Chamados"
        is RequestScreenType.Tarefas -> "Tarefas"
        is RequestScreenType.ChamadosBeneficiario -> "Chamados"
    }
    val subtitleVisible = screenType is RequestScreenType.Tarefas
    val subtitle = if (subtitleVisible) "Tarefas do Projeto" else ""
    val color = when (screenType) {
        is RequestScreenType.Tarefas -> Color(0xFFFFA726) // Laranja
        else -> Color(0xFF1976D2) // Azul
    }
    val showCounter = screenType is RequestScreenType.Chamados
    val showAddButtonInCounter = screenType is RequestScreenType.ChamadosBeneficiario
    val showAddButtonBelowCards = screenType is RequestScreenType.Tarefas

    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                NavbarCorner()
                Column(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        fontFamily = Poppins,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = color
                    )
                    if (subtitleVisible) {
                        Text(
                            text = subtitle,
                            fontFamily = Poppins,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = color,
                        )
                    }
                }
                Row(modifier = Modifier.padding(8.dp)) {
                    if (showCounter) {
                        Counter(requests.size, color)
                    } else if (showAddButtonInCounter) {
                        AddButton(
                            onClick = { /* ação de adicionar chamado beneficiário */ },
                            color = color
                        )
                    }
                }
            }
        },
        content = { innerPadding ->
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Descomente se tiver o SearchBar implementado
                // SearchBar(
                //     query = searchQuery,
                //     onQueryChange = { searchQuery = it },
                //     onSearch = {},
                //     modifier = Modifier.padding(16.dp)
                // )
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
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
                    LazyColumn(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        items(requests) { request ->
                            RequestItem(request = request)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }

                if (showAddButtonBelowCards) {
                    AddButton(
                        onClick = { /* ação de adicionar tarefa */ },
                        color = color
                    )
                }

                Row {
                    // Aqui você decide para onde navegar:
                    // - Se for Tarefas: vai para Chamados
                    // - Se for ChamadosBeneficiario: vai para projetos do beneficiário
                    // - Se for Chamados: vai para projetos
                    NavigationBar(
                        text = when (screenType) {
                            is RequestScreenType.Tarefas -> "Ir para chamados"
                            is RequestScreenType.ChamadosBeneficiario -> "Ir para projetos do beneficiário"
                            else -> "Ir para projetos"
                        },
                        color = color
                        // Adapte para sua navegação real!
                        // onClick = { ... }
                    )
                }
            }
        }
    )
}

// ---------- PREVIEWS ----------
@Preview(showBackground = true)
@Composable
fun PreviewChamados() {
    RequestsScreen(screenType = RequestScreenType.Chamados)
}

@Preview(showBackground = true)
@Composable
fun PreviewChamadosBeneficiario() {
    RequestsScreen(screenType = RequestScreenType.ChamadosBeneficiario)
}

@Preview(showBackground = true)
@Composable
fun PreviewTarefas() {
    RequestsScreen(screenType = RequestScreenType.Tarefas)
}