package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentPaste
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.*
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import kotlinx.coroutines.launch

sealed class ProjectDetailsType {
    object Beneficiario : ProjectDetailsType()
    object ChamadosPrestador : ProjectDetailsType()
    object TarefasPrestador : ProjectDetailsType()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectDetailsScreen(
    type: ProjectDetailsType,
    navActions: NavActions
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val windowInsets = WindowInsets.navigationBars.asPaddingValues()

    // Ajuste dados e navegação conforme tipo
    val (cardType, infoTitle, infoStyle, navButtonText, navButtonClick, icon, iconColor,
        qtd, qtdProgresso, qtdFechado, navButtonColor) = when (type) {
        ProjectDetailsType.Beneficiario -> {
            Tuple11(
                DetailCardType.Default,
                "Chamados Info",
                InfoCardStyle.Azul,
                "Ir para chamados",
                { navActions.navigate(AppRoutes.ChamadosBeneficiario) },
                Icons.Filled.Person,
                ArchBlue,
                10, 4, 6,
                ArchBlue
            )
        }
        ProjectDetailsType.ChamadosPrestador -> {
            Tuple11(
                DetailCardType.Custom(
                    customIcon = Icons.Filled.Folder,
                    customColor = ArchBlue,
                    customShowButton = false
                ),
                "Chamados Info",
                InfoCardStyle.Azul,
                "Ir para chamados", // <-- texto correto!
                { navActions.navigate(AppRoutes.Chamados) }, // <-- navega para chamados
                Icons.Filled.ContentPaste,
                ArchBlue,
                25, 10, 15,
                ArchBlue
            )
        }
        ProjectDetailsType.TarefasPrestador -> {
            Tuple11(
                DetailCardType.SemBotao,
                "Tarefas Info",
                InfoCardStyle.Laranja,
                "Ir para tarefas", // <-- texto correto!
                { navActions.navigate(AppRoutes.Tarefas) }, // <-- navega para tarefas
                Icons.Filled.Person,
                ArchOrange,
                33, 16, 16,
                ArchOrange
            )
        }
    }

    ModalNavigationDrawer(
        drawerContent = {
            NavAppPrestador(
                navActions = navActions,
                closeDrawer = { scope.launch { drawerState.close() } }
            )
        },
        drawerState = drawerState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .padding(windowInsets)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                NavbarCorner { scope.launch { drawerState.open() } }
                Spacer(modifier = Modifier.width(16.dp))
                ProjectTitle(
                    title = "Projetos ECORP",
                    color = ArchBlack,
                    fontSize = 32.sp,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            DetailCard(
                title = "Projeto de Abelha",
                status = "Em progresso",
                startDate = "07/03/2025",
                endDate = "07/03/2025",
                buttonText = "Finalizar",
                onButtonClick = { /* ação do botão */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .shadow(6.dp, RoundedCornerShape(16.dp))
                    .background(Color.White, RoundedCornerShape(16.dp)),
                cardType = cardType
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProjectTitle(
                    title = infoTitle,
                    color = ArchBlack,
                    fontSize = 32.sp,
                    modifier = Modifier
                )
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = iconColor,
                    modifier = Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            InfoCard(
                text = infoTitle.removeSuffix(" Info") + ":",
                qtd = qtd,
                qtdProgresso = qtdProgresso,
                qtdFechado = qtdFechado,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .shadow(6.dp, RoundedCornerShape(16.dp))
                    .background(Color.White, RoundedCornerShape(16.dp)),
                style = infoStyle
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                NavigationButton(
                    text = navButtonText,
                    modifier = Modifier,
                    onClick = navButtonClick, // <-- O clique funciona aqui!
                    style = NavigationButtonStyle.Custom(navButtonColor)
                )
            }
        }
    }
}

// Helper tuple for multiple returns
data class Tuple11<A, B, C, D, E, F, G, H, I, J, K>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
    val sixth: F,
    val seventh: G,
    val eighth: H,
    val ninth: I,
    val tenth: J,
    val eleventh: K
)