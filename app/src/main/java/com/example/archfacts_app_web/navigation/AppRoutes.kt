package com.example.archfacts_app_web.navigation

sealed class AppRoutes(
    val route: String,
    val args: List<String> = emptyList()
) {
    object Home : AppRoutes("home")
    object Registro : AppRoutes("Registro")

    data class Perfil(val idUsuario: String) : AppRoutes(
        route = "perfil/${idUsuario}",
        args = listOf(idUsuario)
    )
}
