package com.example.archfacts_app_web.data.network

import com.example.archfacts_app_web.data.models.EmpresaParceira
import com.example.archfacts_app_web.data.models.LoginRequest
import com.example.archfacts_app_web.data.models.LoginResponse
import com.example.archfacts_app_web.data.models.Servico
import com.example.archfacts_app_web.data.models.User
import kotlinx.serialization.json.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("auth/registro")
    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    suspend fun cadastrarUsuario(
        @Body user: User
    ): Response<JsonObject>

    @POST("auth/login")
    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>


        @GET("negocios")
        suspend fun getEmpresasParceiras(): List<EmpresaParceira>

        @GET("negocios/{idNegocio}")
        suspend fun getEmpresaById(@Path("idNegocio") idNegocio: String): EmpresaParceira

    @GET("servicos/{idNegocio}")
    suspend fun getServicosEmpresa(@Path("idNegocio") idNegocio: String): List<Servico>
}