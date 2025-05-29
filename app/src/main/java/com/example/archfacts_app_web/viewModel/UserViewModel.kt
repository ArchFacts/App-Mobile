package com.example.archfacts_app_web.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.archfacts_app_web.data.models.User
import com.example.archfacts_app_web.data.network.RetrofitInstance
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
                val user = User(
                    nome = nome.trim(),
                    email = email.trim(),
                    telefone = telefone.trim(),
                    senha = senha
                )

                // Verificação adicional
                println("Ordem dos campos no objeto: ${user.toString()}")

                val response = repository.cadastrarUsuario(user)

                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    val errorBody = response.errorBody()?.string() ?: "Erro desconhecido"
                    onError("Erro ${response.code()}: $errorBody")
                }
            } catch (e: Exception) {
                onError("Falha: ${e.message ?: "Erro desconhecido"}")
            }
        }
    }
}