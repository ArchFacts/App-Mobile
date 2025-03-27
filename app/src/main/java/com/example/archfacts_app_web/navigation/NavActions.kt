package com.example.archfacts_app_web.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.archfacts_app_web.screens.HeroSection
import com.example.archfacts_app_web.screens.Register

@Composable
fun rememberNavActions(navController: NavHostController): NavActions {
    return remember(navController) { NavActions(navController) }
}

class NavActions(private val navController: NavHostController) {
    fun navigate(route: AppRoutes) {
        try {
            println("Tentando navegar para: ${route.route}")
            navController.navigate(route.route) {
                launchSingleTop = true
                restoreState = true
            }
        } catch (e: Exception) {
            println("Erro de navegação: ${e.localizedMessage}")
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
            val actions = remember(navController) { NavActions(navController) }
            HeroSection(actions)
        }

        composable(route = AppRoutes.Registro.route) {
            val actions = remember(navController) { NavActions(navController) }
            Register(actions)
        }

        composable(AppRoutes.Perfil.padrao_rota) { input ->
            val perfil = AppRoutes.Perfil.fromArgs(input)
            // TELA_PERFIL (perfil)
        }
    }
}