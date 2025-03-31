package com.example.archfacts_app_web.navigation

import android.service.credentials.RemoteEntry
import androidx.navigation.NavBackStackEntry
import kotlinx.serialization.Serializable

sealed class AppRoutes(
    val route: String,
    val args: List<String> = emptyList()
) {
    object Home : AppRoutes("home")
    object Registro : AppRoutes("registro")

    data class Perfil(val idUsuario: String) : AppRoutes(
        route = "perfil/$idUsuario",
        args = listOf(idUsuario)
    ) {
        companion object {
            const val padrao_rota = "perfil/{idUsuario}"

            fun fromArgs(entry: NavBackStackEntry): Perfil {
                val id = entry.arguments?.getString("idUsuario") ?: ""
                return Perfil(id)
            }
        }
    }

    // EXEMPLO
    data class ProjetosBeneficiario(val idUsuario: String, val idNegocio: String) : AppRoutes(
        route = "projetos/{idUsuario}/{idNegocio}",
        args = listOf(idUsuario, idNegocio)
    )
}
