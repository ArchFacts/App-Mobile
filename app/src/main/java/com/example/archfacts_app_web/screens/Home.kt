package com.example.archfacts_app_web.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
        HeroSection()
        ProblemSection()
        SolutionSection()
        RoleSection()
        ContactSection()
        FooterSection()
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}