package com.example.archfacts_app_web.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.FooterProposal
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Confirmation2() {
    val servicoOptions = listOf("Serviço A", "Serviço B", "Serviço C")
    var selectedServico by remember { mutableStateOf(servicoOptions[0]) }
    var expandedServico by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Confirmação dos dados",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Poppins,
            color = Color(0xFF0E0C19),
            textAlign = TextAlign.Center,
        )

        Text(
            text = " Confirme os dados antes de enviar a solicitação para {negocio.nome}",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text("Empresa: ", fontFamily = Poppins, fontSize = 20.sp)
            Text("Volkswagen", fontWeight = FontWeight.Bold, color = Color(0xFF033E8C), fontFamily = Poppins, fontSize = 20.sp)

            Text("Solicitante: ", fontFamily = Poppins, fontSize = 20.sp)
            Text("Julia", fontWeight = FontWeight.Bold, color = Color(0xFF033E8C), fontFamily = Poppins, fontSize = 20.sp)

            Text("Email empresa: ", fontFamily = Poppins, fontSize = 20.sp)
            Text("volks@gmail.com", fontWeight = FontWeight.Bold, color = Color(0xFF033E8C), fontFamily = Poppins, fontSize = 20.sp)

            Text("Email solicitante: ", fontFamily = Poppins, fontSize = 20.sp)
            Text("julia@gmail.com", fontWeight = FontWeight.Bold, color = Color(0xFF033E8C), fontFamily = Poppins, fontSize = 20.sp)

            Text("CEP: ", fontFamily = Poppins, fontSize = 20.sp)
            Text("098658-90", fontWeight = FontWeight.Bold, color = Color(0xFF033E8C), fontFamily = Poppins, fontSize = 20.sp)

            Text("Endereço: ", fontFamily = Poppins, fontSize = 20.sp)
            Text("Rua porto da folha", fontWeight = FontWeight.Bold, color = Color(0xFF033E8C), fontFamily = Poppins, fontSize = 20.sp)

            Text("Nº: ", fontFamily = Poppins, fontSize = 20.sp)
            Text("1225", fontWeight = FontWeight.Bold, color = Color(0xFF033E8C), fontFamily = Poppins, fontSize = 20.sp)

            Text("Complemento: ", fontFamily = Poppins, fontSize = 20.sp)
            Text("Apt 14", fontWeight = FontWeight.Bold, color = Color(0xFF033E8C), fontFamily = Poppins, fontSize = 20.sp)

            Text("Data: ", fontFamily = Poppins, fontSize = 20.sp)
            Text("07/03/2005", fontWeight = FontWeight.Bold, color = Color(0xFF033E8C), fontFamily = Poppins, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        ExposedDropdownMenuBox(
            expanded = expandedServico,
            onExpandedChange = { expandedServico = !expandedServico },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            TextField(
                value = selectedServico,
                onValueChange = {},
                readOnly = true,
                label = { Text("Serviços Escolhidos") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedServico)
                },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expandedServico,
                onDismissRequest = { expandedServico = false }
            ) {
                servicoOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedServico = option
                            expandedServico = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomButton(
                "Voltar",
                { println("Clicou em Voltar") },
                165.dp,
                35.dp,
                Color(0xFF033E8C)
            )

            CustomButton(
                "Continuar",
                { println("Clicou em Continuar") },
                165.dp,
                35.dp,
                ArchOrange
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        FooterProposal(activeIndex = 0, modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun Confirmation2Preview() {
    Confirmation2()
}