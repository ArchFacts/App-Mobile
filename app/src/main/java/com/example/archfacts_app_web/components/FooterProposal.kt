package com.example.archfacts_app_web.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme

@Composable
fun FooterProposal(
    activeIndex: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(35.dp)
            .background(Color(0xFF0E0C19)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(4) { index ->
                Box(
                    modifier = Modifier
                        .size(width = 60.dp, height = 12.dp)
                        .clip(CircleShape)
                        .background(if (index == activeIndex) Color.White else Color.Gray)
                )
                if (index < 3) {
                    Spacer(modifier = Modifier.width(22.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FooterProposalPreview() {
    ArchFactsAppWebTheme {
        FooterProposal(activeIndex = 0)
    }
}