package com.example.archfacts_app_web

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.components.EnterpriseCard
import com.example.archfacts_app_web.components.HamburguerMenu
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.Poppins


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartnerCompaniesScreen() {
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Empresas Parceiras",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF033E8C)

                    )
                },
                navigationIcon = {
                    HamburguerMenu(
                        modifier = Modifier.padding(12.dp)
                    )
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .height(900.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                // Barra de pesquisa
                SearchBar(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it },
                    onSearch = { /* Lógica de pesquisa */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                Spacer(modifier = Modifier.height(25.dp))

                // Cards das empresas
                EnterpriseCard(
                    companyName = "Google",
                    cardHeight = 120.dp,
                    registrationDate = "01/09/2001",
                    companyImage = R.drawable.google3
                )
                Spacer(modifier = Modifier.height(16.dp))
                EnterpriseCard(
                    companyName = "Microsoft",
                    cardHeight = 120.dp,
                    registrationDate = "15/06/2015",
                    companyImage = R.drawable.microsoft
                )
                Spacer(modifier = Modifier.height(16.dp))
                EnterpriseCard(
                    companyName = "Shell",
                    cardHeight = 120.dp,
                    registrationDate = "22/04/2008",
                    companyImage = R.drawable.shell
                )
                Spacer(modifier = Modifier.height(16.dp))
                EnterpriseCard(
                    companyName = "VolksWagen",
                    cardHeight = 120.dp,
                    registrationDate = "24/11/2004",
                    companyImage = R.drawable.volks
                )
                Spacer(modifier = Modifier.height(16.dp))
                EnterpriseCard(
                    companyName = "ECORP",
                    cardHeight = 120.dp,
                    registrationDate = "11/10/2019"
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    )
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
            Icon(Icons.Default.Search, contentDescription = "Ícone de pesquisa", tint = ArchBlue)
        },
        placeholder = {
            Text("Pesquisar...", color = ArchBlue)
        },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = MaterialTheme.shapes.medium,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = ArchBlue,
            unfocusedIndicatorColor = ArchBlue,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        singleLine = true
    )
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    ArchFactsAppWebTheme {
        PartnerCompaniesScreen()
    }
}