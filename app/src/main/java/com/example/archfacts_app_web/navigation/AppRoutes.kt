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
    object GreetingsPrestador : AppRoutes("greeetings-prestador")
    object PropostaScreen : AppRoutes("proposta-screen")
    object ChoiceScreen : AppRoutes("choice-screen")
    object ProjectDetailsBeneficiario : AppRoutes("project_details_beneficiario")
    object ProjectDetailsChamados : AppRoutes("project_details_chamados")
    object ProjectDetailsTarefas : AppRoutes("project_details_tarefas")
    object Eventos : AppRoutes("eventos")
    object ProfileNegocio : AppRoutes("profile-negocio")

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
