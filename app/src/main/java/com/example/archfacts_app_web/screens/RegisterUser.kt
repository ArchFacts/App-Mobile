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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.example.archfacts_app_web.data.models.User
import com.example.archfacts_app_web.data.network.RetrofitInstance
import com.example.archfacts_app_web.viewModel.UserViewModel
import com.example.archfacts_app_web.viewModel.UserViewModelFactory
import kotlin.random.Random

@Composable
fun RegisterUser(navActions: NavActions) {
    val nome = remember { mutableStateOf("") }
    val telefone = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val confirmacaoSenha = remember { mutableStateOf("") }

    val context = LocalContext.current
    val userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(context)
    )

    val inputs = listOf(
        FormInput("Nome:", "", nome.value, onValueChange = { nome.value = it }),
        FormInput("Telefone:", "", telefone.value, onValueChange = { telefone.value = it }),
        FormInput("Email:", "", email.value, onValueChange = { email.value = it }),
        FormInput("Senha:", "", isPassword = true, onValueChange = { senha.value = it }),
        FormInput(
            "Confirmação de senha:",
            "",
            isPassword = true,
            onValueChange = { confirmacaoSenha.value = it })
    )

    Scaffold(
        topBar = { NavbarVariation() },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.White)
                    .verticalScroll(rememberScrollState()),
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
                                if (senha.value != confirmacaoSenha.value) {
                                    Toast.makeText(
                                        context,
                                        "Senhas não coincidem!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@CustomButton
                                }

                                userViewModel.cadastrarUsuario(
                                    nome = nome.value,
                                    email = email.value,
                                    telefone = telefone.value,
                                    senha = senha.value,
                                    onSuccess = {
                                        Toast.makeText(
                                            context,
                                            "Cadastro feito!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        navActions.navigateToHome()
                                    },
                                    onError = { erro ->
                                        Toast.makeText(context, "Erro: $erro", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                )
                            },
                            width = 200.dp,
                            height = 35.dp,
                            backgroundColor = ArchBlue,
                        )
                    },
                    modifier = Modifier,
                    cliqueSeta = { /*...*/ },
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