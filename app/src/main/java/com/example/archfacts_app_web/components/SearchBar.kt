package com.example.archfacts_app_web.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
            .fillMaxWidth()
            .height(56.dp),
        shape = MaterialTheme.shapes.medium,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFF5F5F5), // Fundo levemente cinza
            focusedIndicatorColor = Color.Gray, // Linha na parte de baixo quando focado
            unfocusedIndicatorColor = Color.LightGray, // Linha na parte de baixo quando não focado
            focusedTextColor = Color.Black, // Cor do texto quando focado
            unfocusedTextColor = Color.Black // Cor do texto quando não focado
        ),
        singleLine = true
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    var query by remember { mutableStateOf("") } // Estado para o texto da pesquisa

    SearchBar(
        query = query, // Passa o estado como valor para o query
        onQueryChange = { newQuery -> query = newQuery }, // Atualiza o estado quando o texto muda
        onSearch = { /* Lógica de pesquisa */ }, // Função vazia por enquanto
        modifier = Modifier // Modificador padrão
    )
}