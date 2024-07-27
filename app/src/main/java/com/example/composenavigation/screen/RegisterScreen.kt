package com.example.composenavigation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.composenavigation.navigation.AppNavigationItem
import com.example.composenavigation.navigation.LoginNavigationItem

@Composable
fun RegisterScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello register!"
        )
        Button(onClick = {navController.popBackStack()}) {
            Text(
                text = ""
            )
        }
    }
}
