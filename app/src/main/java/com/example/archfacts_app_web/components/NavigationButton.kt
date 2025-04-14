package com.example.archfacts_app_web.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .shadow(6.dp, RoundedCornerShape(16.dp))
            .background(Color.White, RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .weight(1f),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = text,
                color = ArchBlack,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
            )
        }

        Box(
            modifier = Modifier
                .height(58.dp)
                .width(38.dp)
                .clip(RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp))
                .background(ArchBlue),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        NavigationButton(
            text = "Ir para chamados",
            modifier = Modifier.fillMaxWidth(0.9f),
            onClick = { }
        )
    }
}