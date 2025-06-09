package com.example.archfacts_app_web.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.FormItem
import com.example.archfacts_app_web.components.FormsApp
import com.example.archfacts_app_web.components.NavAppPrestador
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.components.PerfilUsuario
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PropostaScreen(
    navActions: NavActions
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val windowInsets = WindowInsets.navigationBars.asPaddingValues()

    val formItems = listOf(
        FormItem("E-mail do solicitante", "julia@gmail.com", false),
        FormItem("Serviços Escolhidos:", "Carros Estéticos, Carros econômicos", false),
        FormItem("Data de entrega do projeto:", "07/03/2026", false),
        FormItem(
            "Descrição adicional:",
            "O carro estético deve ter um sistema de iluminação LED diferenciado.",
            false
        )
    )

    ModalNavigationDrawer(
        drawerContent = {
            NavAppPrestador(
                navActions = navActions,
                closeDrawer = { scope.launch { drawerState.close() } }
            )
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max)
                ) {
                    NavbarCorner {
                        scope.launch { drawerState.open() }
                    }
                    Text(
                        text = "Proposta de Júlia",
                        fontFamily = Poppins,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = ArchBlue,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            content = { padding ->
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .padding(padding)
                        .padding(windowInsets) // Limitador para navigation bar
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    FormsApp(formItems)
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CustomButton(
                            "Recusar",
                            width = 175.dp,
                            height = 50.dp,
                            backgroundColor = ArchOrange,
                            fontSize = 16.sp,
                            onClick = {})
                        CustomButton("Aceitar",
                            width = 175.dp,
                            height = 50.dp,
                            backgroundColor = ArchBlue,
                            fontSize = 16.sp,
                            onClick = {})
                    }
                }
            }
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PropostaScreenPreview() {
//    val fakeNavActions = object : NavActions(navController = androidx.navigation.compose.rememberNavController()) {}
//    PropostaScreen(navActions = fakeNavActions)
//}