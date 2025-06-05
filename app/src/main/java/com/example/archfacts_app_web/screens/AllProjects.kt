package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.HamburguerMenu
import com.example.archfacts_app_web.components.ProjectTitle
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue

// ---------- TIPOS DE TELA ----------
sealed class ProjectScreenType {
    object Prestador : ProjectScreenType()
    object Beneficiario : ProjectScreenType()
}

// ---------- DADOS MOCKADOS ----------
data class ProjectPrestador(val name: String, val solicitante: String)
data class ProjectBeneficiario(val name: String)

@Composable
fun AllProjectsScreen(type: ProjectScreenType) {
    val query = remember { mutableStateOf("") }

    // Mock dos projetos
    val allProjects = remember {
        when (type) {
            is ProjectScreenType.Prestador -> listOf(
                ProjectPrestador("Projeto de Abelhas", "Solicitante: João"),
                ProjectPrestador("Projeto de Bananas", "Solicitante: Maria"),
                ProjectPrestador("Projeto de Madeiras", "Solicitante: Ana"),
                ProjectPrestador("Projeto de Cozinhas", "Solicitante: Luiz"),
                ProjectPrestador("Projeto de Celulares", "Solicitante: Pedro")
            )
            is ProjectScreenType.Beneficiario -> listOf(
                ProjectBeneficiario("Projeto de Abelhas"),
                ProjectBeneficiario("Projeto de Bananas"),
                ProjectBeneficiario("Projeto de Madeiras"),
                ProjectBeneficiario("Projeto de Cozinhas"),
                ProjectBeneficiario("Projeto de Celulares")
            )
        }
    }

    val filteredProjects = when (type) {
        is ProjectScreenType.Prestador -> {
            (allProjects as List<ProjectPrestador>).filter {
                it.name.contains(query.value, ignoreCase = true)
            }
        }
        is ProjectScreenType.Beneficiario -> {
            (allProjects as List<ProjectBeneficiario>).filter {
                it.name.contains(query.value, ignoreCase = true)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HamburguerMenu(
            modifier = Modifier.align(Alignment.Start)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ProjectTitle(
                title = if (type is ProjectScreenType.Prestador) "Projetos ECORP" else "Projetos do Beneficiário",
                color = ArchBlue,
                modifier = Modifier
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SearchBar(
                query = query.value,
                onQueryChange = { query.value = it },
                onSearch = {},
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))

        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .shadow(8.dp, shape = RoundedCornerShape(12.dp))
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(50.dp)
                ) {
                    if (filteredProjects.isNotEmpty()) {
                        filteredProjects.forEach { project ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .background(ArchBlack, shape = RoundedCornerShape(12.dp))
                                        .border(2.dp, ArchBlack, shape = RoundedCornerShape(12.dp))
                                        .padding(12.dp)
                                        .fillMaxWidth(0.98f)
                                        .height(50.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.align(Alignment.Center)
                                    ) {
                                        // Nome do projeto
                                        Text(
                                            text = when (type) {
                                                is ProjectScreenType.Prestador -> (project as ProjectPrestador).name
                                                is ProjectScreenType.Beneficiario -> (project as ProjectBeneficiario).name
                                            },
                                            color = Color.White,
                                            fontSize = 32.sp
                                        )
                                        // Nome do solicitante, só para Prestador
                                        if (type is ProjectScreenType.Prestador) {
                                            Text(
                                                text = (project as ProjectPrestador).solicitante,
                                                color = Color.LightGray,
                                                fontSize = 16.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text("Nenhum projeto encontrado", color = Color.Gray)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Ícone de pesquisa")
        },
        placeholder = {
            Text("Pesquisar...")
        },
        modifier = modifier.height(56.dp),
        shape = MaterialTheme.shapes.medium,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFF5F5F5),
            focusedIndicatorColor = Color.Gray,
            unfocusedIndicatorColor = Color.LightGray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        singleLine = true
    )
}

// ----------- PREVIEWS -----------

@Preview(showBackground = true)
@Composable
fun PreviewAllProjectsPrestador() {
    AllProjectsScreen(type = ProjectScreenType.Prestador)
}

@Preview(showBackground = true)
@Composable
fun PreviewAllProjectsBeneficiario() {
    AllProjectsScreen(type = ProjectScreenType.Beneficiario)
}