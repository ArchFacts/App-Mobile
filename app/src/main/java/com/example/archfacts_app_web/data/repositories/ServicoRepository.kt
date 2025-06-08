package com.example.archfacts_app_web.data.repositories

import com.example.archfacts_app_web.data.models.Servico
import com.example.archfacts_app_web.data.network.ApiService

class ServicoRepository(private val api: ApiService) {
    suspend fun buscarServicosEmpresa(idNegocio: String): List<Servico> =
        api.getServicosEmpresa(idNegocio)
}