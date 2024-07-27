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
import com.example.composenavigation.navigation.LoginNavigationItem

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello login!"
        )
        Button(onClick = { navController.navigate(LoginNavigationItem.Register.route) }) {
            Text(
                text = "Go to Register"
            )
        }
        Button(onClick = {
            navController.navigate(LoginNavigationItem.ResetPassword.route)
        }) {
            Text(
                text = "Go to Reset password"
            )
        }
    }
}
