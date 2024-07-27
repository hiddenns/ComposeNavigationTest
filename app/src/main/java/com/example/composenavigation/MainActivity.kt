package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.components.BottomNavigationBar
import com.example.composenavigation.navigation.MainNavHost
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            var bottomNavigationVisible by remember {
                mutableStateOf(false)
            }

            ComposeNavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (bottomNavigationVisible) {
                            BottomNavigationBar(navController = navController)
                        }
                    }) { innerPadding ->
                    MainNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        showBottomNavigation = { isVisible ->
                            bottomNavigationVisible = isVisible
                        }
                    )
                }
            }
        }
    }
}