package com.example.archfacts_app_web.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.ArchOrange

@Composable
fun HamburguerMenu(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        repeat(3) {
            Box(
                modifier = Modifier
                    .width(30.dp)
                    .height(4.dp)
                    .background(ArchOrange)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun HamburguerMenuPreview() {
    ArchFactsAppWebTheme {
        HamburguerMenu()
    }
}