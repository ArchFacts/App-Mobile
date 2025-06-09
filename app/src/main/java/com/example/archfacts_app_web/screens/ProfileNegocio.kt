package com.example.archfacts_app_web.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.NavAppPrestador
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.components.ProjectTitle
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.Poppins
import com.example.archfacts_app_web.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.archfacts_app_web.components.PerfilField
import com.example.archfacts_app_web.ui.theme.ArchOrange
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.archfacts_app_web.navigation.NavActions
import kotlinx.coroutines.launch
import androidx.compose.material3.ModalNavigationDrawer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileNegocio(navActions: NavActions) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val windowInsets = WindowInsets.navigationBars.asPaddingValues()

    var email by remember { mutableStateOf("juliacampioto@gmail.com") }
    var isEditingEmail by remember { mutableStateOf(false) }
    var cpf by remember { mutableStateOf("976.134.045-19") }
    var isEditingCpf by remember { mutableStateOf(false) }
    var telefone by remember { mutableStateOf("(11) 93263–6321") }
    var isEditingTelefone by remember { mutableStateOf(false) }
    var cnpj by remember { mutableStateOf("Não possui") }
    var isEditingCnpj by remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerContent = {
            NavAppPrestador(
                navActions = navActions,
                closeDrawer = { scope.launch { drawerState.close() } }
            )
        },
        drawerState = drawerState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(windowInsets)
        ) {
            // Hamburguer funcional:
            NavbarCorner { scope.launch { drawerState.open() } }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                ProjectTitle(title = "Perfil", color = ArchBlack, modifier = Modifier)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
                    .shadow(8.dp, shape = RoundedCornerShape(16.dp))
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.ecorp),
                            contentDescription = "Foto de Perfil",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "E-CORP",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = ArchBlack
                        )
                        Text(
                            text = "Avaliação: 5",
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp,
                            color = ArchOrange
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Adicionar",
                            color = ArchOrange,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Serviço",
                            color = ArchOrange,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "+",
                            color = ArchOrange,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(5.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(ArchBlack, shape = RoundedCornerShape(16.dp))
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "CÓDIGO DE NEGÓCIO",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 10.dp)
                            .background(Color.White, shape = RoundedCornerShape(12.dp))) {
                        Text(
                            text = "550e8400-e29b-41d4-a716-446655440000",
                            color = ArchOrange,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(5.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    PerfilField(
                        label = "Email",
                        value = email,
                        isEditing = isEditingEmail,
                        onValueChange = { email = it },
                        onEditClick = { isEditingEmail = !isEditingEmail }
                    )

                    PerfilField(
                        label = "CPF",
                        value = cpf,
                        isEditing = isEditingCpf,
                        onValueChange = { cpf = it },
                        onEditClick = { isEditingCpf = !isEditingCpf }
                    )

                    PerfilField(
                        label = "Telefone",
                        value = telefone,
                        isEditing = isEditingTelefone,
                        onValueChange = { telefone = it },
                        onEditClick = { isEditingTelefone = !isEditingTelefone }
                    )

                    PerfilField(
                        label = "CNPJ",
                        value = cnpj,
                        isEditing = isEditingCnpj,
                        onValueChange = { cnpj = it },
                        onEditClick = { isEditingCnpj = !isEditingCnpj }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CustomButton(
                            text = "Salvar Alterações",
                            onClick = {
                                println("Email: $email")
                                println("CPF: $cpf")
                                println("Telefone: $telefone")
                                println("CNPJ: $cnpj")
                            },
                            width = 200.dp,
                            height = 50.dp,
                            backgroundColor = ArchOrange,
                            textColor = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = Poppins
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CustomButton(
                        text = "Editar Para Cliente",
                        onClick = {
                            println("Editar para cliente")
                        },
                        width = 200.dp,
                        height = 50.dp,
                        backgroundColor = ArchBlue,
                        textColor = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = Poppins
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}