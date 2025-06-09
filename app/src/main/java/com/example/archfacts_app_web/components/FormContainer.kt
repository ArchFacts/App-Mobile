package com.example.archfacts_app_web.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins

data class FormInput(
    val label: String,
    val placeholder: String,
    val value: String = "",
    val isPassword: Boolean = false,
    val onValueChange: (String) -> Unit = {}
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FormInputField(
    label: String,
    placeholder: String,
    value: String,
    isPassword: Boolean,
    onValueChange: (String) -> Unit
) {
//    var text: String by remember { mutableStateOf("") }
//    var password: String by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }


    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = label,
            color = ArchBlue,
            fontSize = 20.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Light
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            if (isPassword) {
                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    placeholder = {
                        Text(
                            text = placeholder, // Só dica, não o valor!
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    },
                    visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (senhaVisivel)
                            painterResource(id = R.drawable.showing_eye)
                        else painterResource(id = R.drawable.not_showing_eye)

                        Icon(
                            painter = image,
                            contentDescription = "Mostrar (não) senha",
                            modifier = Modifier.clickable { senhaVisivel = !senhaVisivel }
                        )
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = ArchBlue,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    singleLine = true // Adicione para não quebrar linha na senha
                )
            } else {
                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    placeholder = {
                        Text(
                            text = placeholder,
                            color = Color.Black,
                            fontSize = 14.sp,
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(fontSize = 16.sp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = ArchBlue,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    singleLine = true
                )
            }
            HorizontalDivider(
                color = Color.Black,
                thickness = 0.5.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun FormContainer(
    inputs: List<FormInput>,
    shape: Shape = RectangleShape,
    title: String? = null,
    mostrarSeta: Boolean = false,
    button: @Composable (() -> Unit)? = null,
    cliqueSeta: () -> Unit = {},
    onInputChange: (Int, String) -> Unit = { _, _ -> },
    modifier: Modifier
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(
                12.dp,
                RoundedCornerShape(15.dp),
                clip = true,
                ambientColor = Color.Black.copy(alpha = 0.8f),
                spotColor = Color.Black.copy(alpha = 0.8f)
            ),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (title != null && mostrarSeta) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Image(painter = painterResource(id = R.drawable.return_arrow),
                        contentDescription = "Voltar",
                        modifier = Modifier
                            .size(48.dp)
                            .clickable { cliqueSeta() }
                            .fillMaxWidth())
                }
                Row {
                    Text(
                        text = title,
                        color = ArchBlue,
                        fontSize = 28.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }

            inputs.forEach { input ->
                FormInputField(
                    label = input.label,
                    placeholder = input.placeholder,
                    value = input.value,
                    isPassword = input.isPassword,
                    onValueChange = input.onValueChange
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            button?.invoke()
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun FormContainerPreview() {
//    val inputs = listOf(
//        FormInput(label = "E-mail:", placeholder = ""),
//        FormInput(label = "Nome:", placeholder = ""),
//        FormInput(label = "Telefone:", placeholder = ""),
//        FormInput(label = "Mensagem:", placeholder = ""),
//        FormInput(label = "Senha:", placeholder = "", isPassword = true)
//    )
//
//    FormContainer(
//        inputs = inputs,
//        title = "Cadastro",
//        button = {
//            CustomButton(
//                text = "Cadastrar",
//                onClick = { },
//                width = 200.dp,
//                height = 35.dp,
//                backgroundColor = ArchBlue,
//            )
//        },
//        mostrarSeta = true,
//        modifier = Modifier
//    )
//}
