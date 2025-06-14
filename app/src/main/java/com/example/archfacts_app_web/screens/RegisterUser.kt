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
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.screens.home_sections.Footer
import com.example.archfacts_app_web.ui.theme.ArchBlue
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.archfacts_app_web.data.models.User
import com.example.archfacts_app_web.data.network.RetrofitInstance
import com.example.archfacts_app_web.viewModel.UserViewModel
import com.example.archfacts_app_web.viewModel.UserViewModelFactory
import kotlin.random.Random

@Composable
fun RegisterUser(navActions: NavActions) {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmacaoSenha by remember { mutableStateOf("") }


//    val (nome, setNome) = remember { mutableStateOf("") }
//    val (telefone, setTelefone) = remember { mutableStateOf("") }
//    val (email, setEmail) = remember { mutableStateOf("") }
//    val (senha, setSenha) = remember { mutableStateOf("") }
//    val (confirmacaoSenha, setConfirmacaoSenha) = remember { mutableStateOf("") }

    val context = LocalContext.current
    val userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(context)
    )

    // 3. Seu FormContainer EXATAMENTE como estava
    val inputs = listOf(
        FormInput("Nome:", "", value = nome, onValueChange = { nome=(it) }),
        FormInput("Email:", "", value = email, onValueChange = { email= (it) }),
        FormInput("Telefone:", "", value = telefone, onValueChange = { telefone=(it) }),
        FormInput("Senha:", "", isPassword = true, value = senha, onValueChange = { senha=(it) }),
        FormInput(
            "Confirmação de senha:",
            "",
            isPassword = true,
            value = confirmacaoSenha,
            onValueChange = { confirmacaoSenha=(it) })
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
                    cliqueSeta = { navActions.navigate(AppRoutes.Home) },
                    button = {
                        CustomButton(
                            text = "Cadastrar",
                            onClick = {
                                // Validação básica
                                if (senha != confirmacaoSenha) {
                                    Toast.makeText(
                                        context,
                                        "Senhas não coincidem!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@CustomButton
                                }

                                userViewModel.cadastrarUsuario(
                                    nome = nome,
                                    email = email,
                                    telefone = telefone,
                                    senha = senha,
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
                    modifier = Modifier.weight(1f),
                    // Captura dos valores dos campos
                    cliqueSeta = { /*...*/ },
                    onInputChange = { index, value ->
                        when (index) {
                            0 -> nome = value
                            1 -> email = value
                            2 -> telefone = value
                            3 -> senha = value
                            4 -> confirmacaoSenha = value
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