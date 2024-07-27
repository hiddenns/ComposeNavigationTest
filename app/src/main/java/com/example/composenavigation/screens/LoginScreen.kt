package com.example.composenavigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    navigateToRegister: () -> Unit,
    navigateToResetPassword: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello login!")
        Button(onClick = {
            navigateToRegister()
        }) {
            Text(text = "Go to Register")
        }
        Button(onClick = {
            navigateToResetPassword()
        }) {
            Text(text = "Go to Reset password")
        }
    }
}
