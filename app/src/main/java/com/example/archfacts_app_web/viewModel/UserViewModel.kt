package com.example.archfacts_app_web.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.archfacts_app_web.data.models.User
import com.example.archfacts_app_web.data.repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    fun cadastrarUsuario(
        nome: String,
        email: String,
        telefone: String,
        senha: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val usuario = User(
                    nome = nome,
                    email = email,
                    telefone = telefone,
                    senha = senha
                )

                val response = repository.cadastrarUsuario(usuario)

                when {
                    response.isSuccessful -> onSuccess()
                    response.code() == 409 -> onError("Email já cadastrado")
                    else -> onError("Erro ${response.code()}: ${response.message()}")
                }
            } catch (e: Exception) {
                onError("Erro de rede: ${e.localizedMessage ?: "Erro desconhecido"}")
            }
        }
    }
}