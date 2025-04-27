package com.example.archfacts_app_web.data.network

import com.example.archfacts_app_web.data.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(".")
    suspend fun cadastrarUsuario(@Body user: User): Response<User>
}