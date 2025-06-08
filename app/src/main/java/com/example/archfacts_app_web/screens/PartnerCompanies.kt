package com.example.archfacts_app_web

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.EnterpriseCard
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartnerCompaniesScreen(navActions: NavActions) {
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
                    text = "Empresas Parceiras",
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
                    .height(900.dp)
                    .verticalScroll(rememberScrollState())
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

@Preview(showBackground = false)
@Composable
fun PartnerCompaniesPreview() {
    ArchFactsAppWebTheme {
    }
}