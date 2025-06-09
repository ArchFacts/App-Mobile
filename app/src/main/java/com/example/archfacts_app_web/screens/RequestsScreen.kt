package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.CardType
import com.example.archfacts_app_web.components.Counter
import com.example.archfacts_app_web.components.NavAppPrestador
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.components.NavigationBar
import com.example.archfacts_app_web.enums.RequestEnum
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.Poppins
import com.example.archfacts_app_web.viewModel.RequestsViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel


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
fun RequestItem(
    request: RequestData,
    onOpen: () -> Unit // <-- Novo parâmetro para botão de detalhes
) {
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
                modifier = Modifier
                    .size(22.dp)
                    .clickable { onOpen() } // <-- Botão de ação
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = request.title,
                fontWeight = FontWeight.Medium,
                fontFamily = Poppins,
                maxLines = 2,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
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
                // Pode adicionar outros ícones aqui se quiser
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RequestsScreen(
    screenType: RequestScreenType,
    navActions: NavActions,
    viewModel: RequestsViewModel = viewModel()
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val windowInsets = WindowInsets.navigationBars.asPaddingValues()
    var searchQuery by remember { mutableStateOf("") }

    val requests = viewModel.getRequests(
        when (screenType) {
            is RequestScreenType.Chamados, is RequestScreenType.ChamadosBeneficiario -> CardType.Chamados
            is RequestScreenType.Tarefas -> CardType.Tarefas
        }
    )

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
            containerColor = Color.White,
            topBar = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    NavbarCorner { scope.launch { drawerState.open() } }
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
                                onClick = { navActions.goBack() },
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
                        .padding(windowInsets)
                        .background(Color.White)
                ) {
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
                                RequestItem(
                                    request = request,
                                    onOpen = {
                                        when (screenType) {
                                            is RequestScreenType.Tarefas ->
                                                navActions.navigate(AppRoutes.Tarefas)
                                            is RequestScreenType.Chamados ->
                                                navActions.navigate(AppRoutes.Chamados)
                                            is RequestScreenType.ChamadosBeneficiario ->
                                                navActions.navigate(AppRoutes.ChamadosBeneficiario)
                                        }
                                    }
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }
                    }
                }
            }
        )
    }
}
//
//// ---------- PREVIEWS ----------
//@Preview(showBackground = true)
//@Composable
//fun PreviewChamados() {
//    // Passe um navActions fake para preview
//    val fakeNavActions = object : NavActions(navController = androidx.navigation.compose.rememberNavController()) {}
//    RequestsScreen(screenType = RequestScreenType.Chamados, navActions = fakeNavActions)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewChamadosBeneficiario() {
//    val fakeNavActions = object : NavActions(navController = androidx.navigation.compose.rememberNavController()) {}
//    RequestsScreen(screenType = RequestScreenType.ChamadosBeneficiario, navActions = fakeNavActions)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewTarefas() {
//    val fakeNavActions = object : NavActions(navController = androidx.navigation.compose.rememberNavController()) {}
//    RequestsScreen(screenType = RequestScreenType.Tarefas, navActions = fakeNavActions)
//}