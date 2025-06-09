package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.archfacts_app_web.data.models.LoginResponse
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.screens.home_sections.Footer
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.viewModel.LoginUiState
import com.example.archfacts_app_web.viewModel.UserViewModel
import com.example.archfacts_app_web.viewModel.UserViewModelFactory

@Composable
fun Login(
    modifier: Modifier = Modifier,
    navActions: NavActions,
    userViewModel: UserViewModel = viewModel(factory = UserViewModelFactory(LocalContext.current))
) {
    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    val loginState = userViewModel.loginState.value

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
                    listOf(
                        FormInput("Login:","Digite seu login", login, onValueChange = { login = it }),
                        FormInput("Senha","Digite sua senha", value = senha, isPassword = true, onValueChange = { senha = it }),
                    ),
                    RectangleShape,
                    title = "Login",
                    mostrarSeta = true,
                    cliqueSeta = { navActions.navigate(AppRoutes.Home) },
                    button = {
                        CustomButton(
                            text = if (loginState is LoginUiState.Loading) "Entrando..." else "Login",
                            onClick = {
                                userViewModel.login(
                                    login = login,
                                    senha = senha,
                                    onSuccess = {
                                        navActions.navigateToHome()
                                    },
                                    onError = {
                                        // Mostrar erro, se quiser
                                    }
                                )
                            },
                            width = 200.dp,
                            height = 35.dp,
                            backgroundColor = ArchOrange,
                            // enabled = loginState !is LoginUiState.Loading // Só se existir esse parâmetro no seu botão!
                        )
                    },
                    modifier = Modifier.weight(1f)
                )
                if (loginState is LoginUiState.Error) {
                    Text(loginState.message, color = Color.Red)
                }
            }
        },
        bottomBar = { Footer() }
    )
}
@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login(navActions = NavActions(rememberNavController()))
}