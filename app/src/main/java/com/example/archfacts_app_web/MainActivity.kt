package com.example.archfacts_app_web

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.archfacts_app_web.navigation.AppNavGraph
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArchFactsAppWebTheme {
                val navController = rememberNavController()
                println("Criou navController")
                AppNavGraph(navController)
            }
        }
    }
}