package com.example.archfacts_app_web.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.archfacts_app_web.components.HamburguerMenu
import com.example.archfacts_app_web.components.ProjectTitle
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.Poppins
import com.example.archfacts_app_web.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.archfacts_app_web.components.PerfilField

@Composable
@Preview
fun ProfileBeneficiario() {
    var email by remember { mutableStateOf("luisalmeida@volks.com") }
    var isEditingEmail by remember { mutableStateOf(false) }

    var telefone by remember { mutableStateOf("(11) 983749184") }
    var isEditingTelefone by remember { mutableStateOf(false) }

    var dataRegistro by remember { mutableStateOf("07/03/2005") }
    var isEditingData by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HamburguerMenu(modifier = Modifier.align(Alignment.Start))

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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Luis Gustavo",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Medium,
                        color = ArchBlack
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.homem),
                        contentDescription = "Foto de Perfil",
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray),
                        contentScale = ContentScale.Crop
                    )
                }
            }

        Spacer(modifier = Modifier.height(24.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ArchBlack, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                PerfilField(
                    label = "Email",
                    value = email,
                    isEditing = isEditingEmail,
                    onValueChange = { email = it },
                    onEditClick = { isEditingEmail = !isEditingEmail }
                )

                PerfilField(
                    label = "Telefone",
                    value = telefone,
                    isEditing = isEditingTelefone,
                    onValueChange = { telefone = it },
                    onEditClick = { isEditingTelefone = !isEditingTelefone }
                )

                PerfilField(
                    label = "Data de Registro",
                    value = dataRegistro,
                    isEditing = isEditingData,
                    onValueChange = { dataRegistro = it },
                    onEditClick = { isEditingData = !isEditingData }
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CustomButton(
                        text = "Salvar Alterações",
                        onClick = {
                            println("Email: $email")
                            println("Telefone: $telefone")
                            println("Data de Registro: $dataRegistro")
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
                Spacer(modifier = Modifier.height(24.dp))
            }
    }
}
}