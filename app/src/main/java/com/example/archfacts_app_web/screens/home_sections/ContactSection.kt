package com.example.archfacts_app_web.screens.home_sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.CustomButton
import com.example.archfacts_app_web.components.DescStyle
import com.example.archfacts_app_web.components.FormContainer
import com.example.archfacts_app_web.components.FormInput
import com.example.archfacts_app_web.components.TitleDescContainer
import com.example.archfacts_app_web.components.TitleStyle
import com.example.archfacts_app_web.ui.theme.ArchBlue

@Composable
fun ContactSection() {
    val inputs = listOf(
        FormInput(label = "E-mail:", placeholder = ""),
        FormInput(label = "Nome:", placeholder = ""),
        FormInput(label = "Telefone:", placeholder = ""),
        FormInput(label = "Mensagem:", placeholder = "")

    )

    Column(modifier = Modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        TitleDescContainer(
            200.dp, "Entre em contato", "Caso tenha dúvidas," +
                    " preencha o formulário e entre em contato conosco!", titleStyle = TitleStyle(
                fontSize = 24.sp, fontWeight = FontWeight.Bold
            ),
            descStyle = DescStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
        )

        FormContainer(inputs, modifier = Modifier)

        CustomButton("Enviar", {}, width = 200.dp, 30.dp, ArchBlue, 20.sp)

    }
}

@Preview(showBackground = true)
@Composable
fun ContactSectionPreview() {
    ContactSection()
}