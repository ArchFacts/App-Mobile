package com.example.archfacts_app_web.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.archfacts_app_web.screens.Login
import com.example.archfacts_app_web.screens.ParceriasScreen
import com.example.archfacts_app_web.screens.PartnerCompaniesScreen
import com.example.archfacts_app_web.screens.RegisterUser
import com.example.archfacts_app_web.screens.home_sections.HeroSection

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
    fun navigate(route: String) {
        try {
            println("Tentando navegar para: ${route}")
            navController.navigate(route) {
            }
        } catch (e: Exception) {
            println("Erro de navegação: ${e.message}")
            e.printStackTrace()
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

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Home.route
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
        composable(route = AppRoutes.KnowOurPartners.route) {
            val actions = rememberNavActions(navController)
            ParceriasScreen(actions)
        }
        composable(route = AppRoutes.PartnerCompanies.route) {
            val actions = rememberNavActions(navController)
            PartnerCompaniesScreen(actions)
        }

    }
}