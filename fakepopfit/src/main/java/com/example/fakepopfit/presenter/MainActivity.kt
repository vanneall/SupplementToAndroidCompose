package com.example.fakepopfit.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.fakepopfit.navigation.Navigation
import com.example.fakepopfit.ui.theme.SupplementToAndroidComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SupplementToAndroidComposeTheme {
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}





