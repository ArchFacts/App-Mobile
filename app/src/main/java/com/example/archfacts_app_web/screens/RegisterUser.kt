package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.FormContainer
import com.example.archfacts_app_web.components.FormInput
import com.example.archfacts_app_web.components.NavbarVariation
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.screens.home_sections.Footer
import com.example.archfacts_app_web.ui.theme.ArchBlue
import android.widget.Toast
import com.example.archfacts_app_web.viewModel.UserViewModel
import com.example.archfacts_app_web.viewModel.UserViewModelFactory

@Composable
fun RegisterUser(navActions: NavActions) {
    // 1. Estados dos campos (ocultos, não alteram sua UI)
    val nome = remember { mutableStateOf("") }
    val telefone = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val confirmacaoSenha = remember { mutableStateOf("") }

    // 2. ViewModel para AWS
    val context = LocalContext.current
    val userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(context)
    )

    // 3. Seu FormContainer EXATAMENTE como estava
    val inputs = listOf(
        FormInput("Nome:", ""),
        FormInput("Telefone:", ""),
        FormInput("Email:", ""),
        FormInput("Senha:", "", true),
        FormInput("Confirmação de senha:", "", true)
    )

    Scaffold(
        topBar = { NavbarVariation() },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center
            ) {
                FormContainer(
                    inputs = inputs,
                    shape = RectangleShape,
                    title = "Cadastro",
                    mostrarSeta = true,
                    button = {
                        CustomButton(
                            text = "Cadastrar",
                            onClick = {
                                // Validação básica
                                if (senha.value != confirmacaoSenha.value) {
                                    Toast.makeText(context, "Senhas não coincidem!", Toast.LENGTH_SHORT).show()
                                    return@CustomButton
                                }

                                userViewModel.cadastrarUsuario(
                                    nome = nome.value,
                                    email = email.value,
                                    telefone = telefone.value,
                                    senha = senha.value,
                                    onSuccess = {
                                        Toast.makeText(context, "Cadastro feito!", Toast.LENGTH_SHORT).show()
                                        navActions.navigateToHome()
                                    },
                                    onError = { erro ->
                                        Toast.makeText(context, "Erro: $erro", Toast.LENGTH_SHORT).show()
                                    }
                                )
                            },
                            width = 200.dp,
                            height = 35.dp,
                            backgroundColor = ArchBlue,
                        )
                    },
                    modifier = Modifier.weight(1f),
                    // Captura dos valores dos campos
                    cliqueSeta = { /*...*/ },
                    onInputChange = { index, value ->
                        when (index) {
                            0 -> nome.value = value
                            1 -> telefone.value = value
                            2 -> email.value = value
                            3 -> senha.value = value
                            4 -> confirmacaoSenha.value = value
                        }
                    }
                )
            }
        },
        bottomBar = { Footer() }
    )
}

@Preview
@Composable
private fun RegisterPreview() {
    RegisterUser(navActions = NavActions(rememberNavController()))
}