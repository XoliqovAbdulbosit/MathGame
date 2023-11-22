package com.example.mathgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.mathgame.Navigation.AppNavigation
import com.example.mathgame.ui.theme.MathGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathGameTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}

