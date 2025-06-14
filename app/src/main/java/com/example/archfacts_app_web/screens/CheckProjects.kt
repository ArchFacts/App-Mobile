package com.example.archfacts_app_web

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.EnterpriseCard
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckProjectsScreen() {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NavbarCorner()
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Projetos em Análise",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = Color(0xFF033E8C),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(top = paddingValues.calculateTopPadding() + 15.dp)
                    .verticalScroll(rememberScrollState())
                    .fillMaxHeight()
            ) {
                TextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Ícone de pesquisa", tint = ArchBlue)
                    },
                    placeholder = {
                        Text("Pesquisar...", color = ArchBlue)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
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

                Spacer(modifier = Modifier.height(20.dp))

                EnterpriseCard(
                    companyName = "Projeto Aurora",
                    cardHeight = 120.dp,
                    registrationDate = "01/09/2023",
                    companyImage = R.drawable.google3
                )
                Spacer(modifier = Modifier.height(16.dp))
                EnterpriseCard(
                    companyName = "Projeto Atlas",
                    cardHeight = 120.dp,
                    registrationDate = "15/06/2023",
                    companyImage = R.drawable.microsoft
                )
                Spacer(modifier = Modifier.height(16.dp))
                EnterpriseCard(
                    companyName = "Projeto Helix",
                    cardHeight = 120.dp,
                    registrationDate = "22/04/2022",
                    companyImage = R.drawable.shell
                )
                Spacer(modifier = Modifier.height(16.dp))
                EnterpriseCard(
                    companyName = "Projeto Neon",
                    cardHeight = 120.dp,
                    registrationDate = "24/11/2021",
                    companyImage = R.drawable.volks
                )
                Spacer(modifier = Modifier.height(16.dp))
                EnterpriseCard(
                    companyName = "Projeto Eon",
                    cardHeight = 120.dp,
                    registrationDate = "11/10/2020"
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    )
}

@Preview(showBackground = false)
@Composable
fun CheckProjectsPreview() {
    ArchFactsAppWebTheme {
        CheckProjectsScreen()
    }
}