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
    object Login : AppRoutes("login")
    object Chamados : AppRoutes("chamados")
    object ChamadosBeneficiario : AppRoutes("chamados_beneficiario")
    object Tarefas : AppRoutes("tarefas")
    object ProjetosPrestador : AppRoutes("projetos_prestador")
    object ProjetosBeneficiario : AppRoutes("projetos_beneficiario")
    object KnowOurPartners : AppRoutes("know-our-partners")
    object PartnerCompanies : AppRoutes("partner-companies")


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


}
