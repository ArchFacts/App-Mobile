package com.example.archfacts_app_web.data.network

import com.example.archfacts_app_web.data.models.LoginRequest
import com.example.archfacts_app_web.data.models.LoginResponse
import com.example.archfacts_app_web.data.models.User
import kotlinx.serialization.json.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

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
}