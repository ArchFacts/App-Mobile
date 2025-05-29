package com.example.archfacts_app_web.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("nome")
    @Expose(serialize = true)
    val nome: String,

    @SerializedName("email")
    @Expose(serialize = true)
    val email: String,

    @SerializedName("telefone")
    @Expose(serialize = true)
    val telefone: String,

    @SerializedName("senha")
    @Expose(serialize = true)
    val senha: String
) {
    init {
        require(nome.isNotBlank()) { "Nome é obrigatório" }
        require(email.contains("@")) { "Email inválido" }
        require(senha.length >= 6) { "Senha deve ter 6+ caracteres" }
    }
}