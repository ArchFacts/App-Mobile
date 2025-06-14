package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.DetailCard
import com.example.archfacts_app_web.components.HamburguerMenu
import com.example.archfacts_app_web.components.ProjectTitle
import com.example.archfacts_app_web.components.SearchBar
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue

data class ProjectPrestador(val name: String)

@Preview
@Composable
fun AllProjects() {
    val query = remember { mutableStateOf("") }

    val allProjects = remember{
        mutableStateOf(listOf(
            ProjectPrestador("Projeto de Abelhas"),
            ProjectPrestador("Projeto de Bananas"),
            ProjectPrestador("Projeto de Madeiras"),
            ProjectPrestador("Projeto de Cozinhas"),
            ProjectPrestador("Projeto de Celulares")
        ))
    }

    val filteredProjects = allProjects.value.filter {
        it.name.contains(query.value, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HamburguerMenu(
            modifier = Modifier
                .align(Alignment.Start)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ProjectTitle(title = "Projetos ECORP", color = ArchBlue, modifier = Modifier)
        }
        Spacer(
            modifier = Modifier
                .padding(20.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SearchBar(
                query = query.value,
                onQueryChange = { query.value = it },
                onSearch = {},
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
        Spacer(
            modifier = Modifier
                .padding(20.dp)
        )

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
                                    ProjectTitle(
                                        title = project.name,
                                        color = Color.White,
                                        fontSize = 32.sp,
                                        modifier = Modifier.align(Alignment.Center)
                                    )
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
        modifier = modifier
            .height(56.dp),
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