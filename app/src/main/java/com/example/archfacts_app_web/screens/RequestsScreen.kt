package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.SearchBar
import com.example.archfacts_app_web.components.CardType
import com.example.archfacts_app_web.components.Counter
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.components.NavigationBar
import com.example.archfacts_app_web.enums.RequestEnum
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.Poppins

data class RequestData(
    val title: String,
    val date: String,
    val status: RequestEnum,
    val type: CardType
)

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
                text = request.date,
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
fun RequestsScreen(modifier: Modifier = Modifier, type: CardType) {

    var searchQuery by remember { mutableStateOf("") } // Estado para a barra de pesquisa

    val sampleRequests = listOf(
        RequestData(
            title = "Validar cores",
            date = "28 Mar, 10:29",
            status = RequestEnum.FINALIZADO,
            type = type
        ),
        RequestData(
            title = "Corrigir bug UI",
            date = "29 Mar, 14:30",
            status = RequestEnum.EM_PROGRESSO,
            type = type
        ),
        RequestData(
            title = "Validar cores",
            date = "28 Mar, 10:29",
            status = RequestEnum.FINALIZADO,
            type = type
        ),
        RequestData(
            title = "Validar cores",
            date = "28 Mar, 10:29",
            status = RequestEnum.FINALIZADO,
            type = type
        ),
        RequestData(
            title = "Validar cores",
            date = "28 Mar, 10:29",
            status = RequestEnum.FINALIZADO,
            type = type
        ),
        RequestData(
            title = "Validar cores",
            date = "28 Mar, 10:29",
            status = RequestEnum.FINALIZADO,
            type = type
        )
    )

    val title = when (type) {
        is CardType.Chamados -> "Chamados"
        is CardType.Tarefas -> "Tarefas"
    }
    val subtitle = when (type) {
        is CardType.Chamados -> "Projeto de Abelhas"
        is CardType.Tarefas -> "Tarefas do Projeto"
    }
    val color = type.backgroundColor

    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
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
                    Text(
                        text = subtitle,
                        fontFamily = Poppins,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = color,
                    )
                }
                Row(modifier = Modifier.padding(8.dp)) {
                    Counter(
                        25, color
                    )
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
                SearchBar(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it },
                    onSearch = {},
                    modifier = Modifier.padding(16.dp)
                )
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
                            .padding()
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        items(sampleRequests) { request ->
                            RequestItem(request = request)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
                Row(modifier = Modifier.padding(16.dp)) {
                    NavigationBar("Ir para projetos", color)
                }
            }
        },
        bottomBar = {}
    )
}


@Preview
@Composable
fun RequestsScreenPreview() {
    val requestTeste = RequestData(
        "Validar cores", "28 Mar, 10:29", RequestEnum.FINALIZADO,
        CardType.Chamados
    )
    RequestsScreen(type = CardType.Chamados)
}