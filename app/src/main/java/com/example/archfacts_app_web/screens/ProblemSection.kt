package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.components.IconTextContainer

@Composable
fun ProblemSection() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(5.dp),
        verticalArrangement = Arrangement.Center
    ) {
        IconTextContainer()
    }
}

@Preview()
@Composable
fun ProblemSectionPreview() {
    ProblemSection()
}


