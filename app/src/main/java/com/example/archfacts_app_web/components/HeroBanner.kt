package com.example.archfacts_app_web.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.ui.theme.ArchBlackTransparent
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.Poppins

@Composable
fun HeroBanner(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(ArchBlackTransparent)
            .padding(15.dp)
    ) {
        Row {
            Text(
                text = "Eficiência em gestão de negócios",
                fontFamily = Poppins,
                fontWeight = FontWeight.Light,
                color = Color.White,
                fontSize = 12.sp
            )
        }


        Row {
            Text(
                text = "Ideal para donos de negócios se organizarem, colaborarem e captarem clientes.",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                color = Color.White

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroBannerPreview() {
    ArchFactsAppWebTheme {
        HeroBanner()
    }
}