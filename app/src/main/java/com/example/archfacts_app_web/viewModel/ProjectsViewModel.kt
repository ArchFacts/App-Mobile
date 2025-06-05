// ProjectsViewModel.kt
package com.example.archfacts_app_web.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.archfacts_app_web.screens.ProjectBeneficiario
import com.example.archfacts_app_web.screens.ProjectPrestador
import com.example.archfacts_app_web.screens.ProjectScreenType

class ProjectsViewModel : ViewModel() {
    var query by mutableStateOf("")
        private set

    fun onQueryChange(newQuery: String) {
        query = newQuery
    }

    fun getProjects(type: ProjectScreenType): List<Any> {
        return when (type) {
            is ProjectScreenType.Prestador -> listOf(
                ProjectPrestador("Projeto de Abelhas", "Solicitante: João"),
                ProjectPrestador("Projeto de Bananas", "Solicitante: Maria"),
                ProjectPrestador("Projeto de Madeiras", "Solicitante: Ana"),
                ProjectPrestador("Projeto de Cozinhas", "Solicitante: Luiz"),
                ProjectPrestador("Projeto de Celulares", "Solicitante: Pedro")
            )
            is ProjectScreenType.Beneficiario -> listOf(
                ProjectBeneficiario("Projeto de Abelhas"),
                ProjectBeneficiario("Projeto de Bananas"),
                ProjectBeneficiario("Projeto de Madeiras"),
                ProjectBeneficiario("Projeto de Cozinhas"),
                ProjectBeneficiario("Projeto de Celulares")
            )
        }
    }

    fun getFilteredProjects(type: ProjectScreenType): List<Any> {
        val projects = getProjects(type)
        return when (type) {
            is ProjectScreenType.Prestador ->
                (projects as List<ProjectPrestador>).filter {
                    it.name.contains(query, ignoreCase = true)
                }
            is ProjectScreenType.Beneficiario ->
                (projects as List<ProjectBeneficiario>).filter {
                    it.name.contains(query, ignoreCase = true)
                }
        }
    }
}