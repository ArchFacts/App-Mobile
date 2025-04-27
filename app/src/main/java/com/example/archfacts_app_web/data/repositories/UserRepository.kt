package com.example.archfacts_app_web.data.repositories

import com.example.archfacts_app_web.data.models.User
import com.example.archfacts_app_web.data.network.ApiService
import retrofit2.Response

class UserRepository(private val api: ApiService) {

    suspend fun cadastrarUsuario(user: User): Response<User> {
        return api.cadastrarUsuario(user)
    }
}