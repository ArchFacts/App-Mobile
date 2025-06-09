package com.example.archfacts_app_web.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.archfacts_app_web.screens.AllProjectsScreen
import com.example.archfacts_app_web.screens.ChoiceScreen
import com.example.archfacts_app_web.screens.EventosScreen
import com.example.archfacts_app_web.screens.GreetingsPrestador
import com.example.archfacts_app_web.screens.Login
import com.example.archfacts_app_web.screens.ProfileNegocio
import com.example.archfacts_app_web.screens.ProjectScreenType
import com.example.archfacts_app_web.screens.PropostaScreen
import com.example.archfacts_app_web.screens.RegisterUser
import com.example.archfacts_app_web.screens.home_sections.HeroSection
import com.example.archfacts_app_web.screens.ProjectDetailsScreen
import com.example.archfacts_app_web.screens.ProjectDetailsType
import com.example.archfacts_app_web.screens.RequestScreenType
import com.example.archfacts_app_web.screens.RequestsScreen

@Composable
fun rememberNavActions(navController: NavHostController): NavActions {
    return remember(navController) { NavActions(navController) }
}

class NavActions(private val navController: NavHostController) {
    fun navigateToHome() {
        navController.navigate(AppRoutes.Home.route) {
            launchSingleTop = true
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            restoreState = true
        }
    }
    fun navigate(route: AppRoutes) {

        println("Tentando navegar para $route")
        println("NavController atual: $navController")

        try {
            println("Tentando navegar para: ${route.route}")
            navController.navigate(route.route) {
            }
        } catch (e: Exception) {
            println("Erro de navegação: ${e.message}")
            e.printStackTrace()
        }
    }

    fun goBack() = navController.popBackStack()
}

@Composable
fun AppNavGraph(navController: NavHostController) {
//    val navController = rememberNavController() ISSO CRIA OUTRA INSTÂNCIA
    val navActions = rememberNavActions(navController) // <-- FAÇA ISSO UMA VEZ

    NavHost(
        navController = navController,
        startDestination = AppRoutes.GreetingsPrestador.route
    ) {
        composable(route = AppRoutes.Home.route) {
            val actions = rememberNavActions(navController)
            HeroSection(actions)
        }

        composable(route = AppRoutes.Registro.route) {
            val actions = rememberNavActions(navController)
            RegisterUser(actions)
        }
        composable(route = AppRoutes.Login.route) {
            Login(navActions = NavActions(navController))
        }
        composable(route = AppRoutes.GreetingsPrestador.route) {
            val actions = rememberNavActions(navController)
            GreetingsPrestador(actions)
        }
        composable(route = AppRoutes.PropostaScreen.route) {
            val actions = rememberNavActions(navController)
            PropostaScreen(actions)
        }
//        composable(AppRoutes.ProjetosBeneficiario.route) {
//            AllProjectsScreen(type = ProjectScreenType.Beneficiario)
//        }
        composable(AppRoutes.ProjetosPrestador.route) {
            AllProjectsScreen(type = ProjectScreenType.Prestador, navActions = rememberNavActions(navController))
        }
        composable(AppRoutes.ChoiceScreen.route) {
            ChoiceScreen(navActions = rememberNavActions(navController))
        }
        composable(AppRoutes.ProjectDetailsBeneficiario.route) {
            ProjectDetailsScreen(type = ProjectDetailsType.Beneficiario, navActions = navActions)
        }
        composable(AppRoutes.ProjectDetailsChamados.route) {
            ProjectDetailsScreen(type = ProjectDetailsType.ChamadosPrestador, navActions = navActions)
        }
        composable(AppRoutes.ProjectDetailsTarefas.route) {
            ProjectDetailsScreen(type = ProjectDetailsType.TarefasPrestador, navActions = navActions)
        }
        composable(AppRoutes.Chamados.route) {
            RequestsScreen(screenType = RequestScreenType.Chamados, navActions = navActions)
        }
        composable(AppRoutes.Tarefas.route) {
            RequestsScreen(screenType = RequestScreenType.Tarefas, navActions = navActions)
        }
        composable(AppRoutes.ChamadosBeneficiario.route) {
            RequestsScreen(screenType = RequestScreenType.ChamadosBeneficiario, navActions = navActions)
        }
        composable(AppRoutes.Eventos.route){
            val actions = rememberNavActions(navController)
            EventosScreen(actions)
        }
        composable(AppRoutes.ProfileNegocio.route){
            val actions = rememberNavActions(navController)
            ProfileNegocio(actions)
        }
    }
}