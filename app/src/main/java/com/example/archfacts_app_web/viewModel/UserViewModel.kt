package com.example.archfacts_app_web.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.archfacts_app_web.data.models.LoginResponse
import com.example.archfacts_app_web.data.models.User
import com.example.archfacts_app_web.data.network.RetrofitInstance
import com.example.archfacts_app_web.data.repositories.UserRepository
import kotlinx.coroutines.launch

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val response: LoginResponse) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}

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

        val loginState = mutableStateOf<LoginUiState>(LoginUiState.Idle)
        fun login(
            login: String,
            senha: String,
            onSuccess: (LoginResponse) -> Unit,
            onError: (String) -> Unit
        ) {
            viewModelScope.launch {
                loginState.value = LoginUiState.Loading
                try {
                    val response = repository.login(login, senha)
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null) {
                            loginState.value = LoginUiState.Success(body)
                            onSuccess(body)
                        } else {
                            loginState.value = LoginUiState.Error("Resposta vazia do servidor")
                            onError("Resposta vazia do servidor")
                        }
                    } else {
                        val error = response.errorBody()?.string() ?: "Erro desconhecido"
                        loginState.value = LoginUiState.Error(error)
                        onError(error)
                    }
                } catch (e: Exception) {
                    loginState.value = LoginUiState.Error(e.message ?: "Erro desconhecido")
                    onError(e.message ?: "Erro desconhecido")
                }
            }
        }
    }