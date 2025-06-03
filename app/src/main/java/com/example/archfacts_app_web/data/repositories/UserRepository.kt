package com.example.archfacts_app_web.data.repositories

import com.example.archfacts_app_web.data.models.LoginRequest
import com.example.archfacts_app_web.data.models.LoginResponse
import com.example.archfacts_app_web.data.models.User
import com.example.archfacts_app_web.data.network.ApiService
import com.google.gson.Gson
import kotlinx.serialization.json.JsonObject
import okhttp3.ResponseBody
import retrofit2.Response

class UserRepository(private val api: ApiService) {
    suspend fun cadastrarUsuario(user: User): Response<JsonObject> {
        val gson = Gson()
        println("JSON sendo enviado: ${gson.toJson(user)}")
        return api.cadastrarUsuario(user)
    }

    suspend fun login(login: String, senha: String): Response<LoginResponse> {
        return api.login(LoginRequest(login, senha))
    }
}