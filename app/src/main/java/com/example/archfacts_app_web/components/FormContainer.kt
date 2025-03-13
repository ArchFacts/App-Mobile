package com.example.archfacts_app_web.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.Poppins

data class FormInput(
    val label: String,
    val placeholder: String
)

@Composable
fun FormInputField(label: String, placeholder: String) {
    var text: String by remember { mutableStateOf("") }

    Column {
        Text(
            text = label,
            color = ArchBlue,
            fontSize = 12.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Light
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                placeholder = {
                    Text(
                        text = placeholder,
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 16.sp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                singleLine = true
            )
            HorizontalDivider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun FormContainer(inputs: List<FormInput>) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .shadow(
                12.dp,
                RoundedCornerShape(15.dp),
                clip = true,
                ambientColor = Color.Black.copy(alpha = 0.25f),
                spotColor = Color.Black.copy(alpha = 0.25f)
            ),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
    ) {
        Column {
            inputs.forEach { input ->
                FormInputField(input.label, input.placeholder)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormContainerPreview() {
    val inputs = listOf(
        FormInput(label = "E-mail:", placeholder = ""),
        FormInput(label = "Nome:", placeholder = ""),
        FormInput(label = "Telefone:", placeholder = ""),
        FormInput(label = "Mensagem:", placeholder = "")

    )

    FormContainer(inputs = inputs)
}
