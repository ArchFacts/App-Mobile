package com.example.archfacts_app_web.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.Poppins

data class FormItem(
    val label: String,
    val value: String,
    val editavel: Boolean,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormLine(
    label: String,
    value: String,
    editavel: Boolean,
    onValueChange: (String) -> Unit = {}
) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = label,
            fontWeight = FontWeight.SemiBold,
            fontFamily = Poppins,
            fontSize = 24.sp,
            color = ArchBlue
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (editavel) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                shape = RoundedCornerShape(6.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = ArchBlue,
                    unfocusedBorderColor = ArchBlue,
                    focusedTextColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.5.dp,
                        brush = SolidColor(ArchBlue),
                        shape = RoundedCornerShape(6.dp)
                    ),
                singleLine = false,
                maxLines = 3
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.5.dp,
                        brush = SolidColor(ArchBlue),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = value,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins,
                    fontSize = 24.sp,
                )
            }
        }
    }
}

@Composable
fun FormsApp(items: List<FormItem>) {
    Column {
        items.forEach { item ->
            FormLine(label = item.label, value = item.value, editavel = item.editavel)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FormsAppPreview() {
    val formItems = listOf(
        FormItem("E-mail do solicitante", "julia@gmail.com", false),
        FormItem("Serviços Escolhidos:", "Carros Estéticos, Carros econômicos", false),
        FormItem("Data de entrega do projeto:", "07/03/2026", false),
        FormItem(
            "Descrição adicional:",
            "O carro estético deve ter um sistema de iluminação LED diferenciado.",
            false
        )
    )
    FormsApp(formItems)
}