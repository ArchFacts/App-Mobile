package com.example.archfacts_app_web.data.repositories

import com.example.archfacts_app_web.data.models.EmpresaParceira
import com.example.archfacts_app_web.data.network.ApiService

// EmpresaRepository.kt
class EmpresaRepository(private val api: ApiService) {
    suspend fun buscarEmpresasParceiras(): List<EmpresaParceira> = api.getEmpresasParceiras()
    suspend fun buscarEmpresaPorId(idNegocio: String): EmpresaParceira = api.getEmpresaById(idNegocio)
}