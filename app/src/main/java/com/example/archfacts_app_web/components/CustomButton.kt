package com.example.archfacts_app_web.components

import android.graphics.fonts.Font
import android.util.Size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    width: Dp = 150.dp,
    height: Dp = 50.dp,
    backgroundColor: Color = ArchBlue,
    textColor: Color = Color.White,
    fontSize: TextUnit = 16.sp,
    fontFamily : FontFamily = Poppins,
    fontWeight: FontWeight = FontWeight.SemiBold
    ,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(width)
            .height(height),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        Text(text = text, color = textColor,
            fontSize = fontSize,
            fontFamily = fontFamily,
            fontWeight = fontWeight
            )
    }
}


@Preview
@Composable
fun CustomButtonPreview() {
    CustomButton("Saiba mais", { println("Clicou")   })
}