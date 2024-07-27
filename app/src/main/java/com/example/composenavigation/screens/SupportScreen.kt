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
fun SupportScreen(
    navigateToHome: () -> Unit,
    navigateToProfile: () -> Unit,
    navigateBack: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Screen!")
        Button(onClick = {
            navigateToHome()
        }) {
            Text(text = "Go to Home")
        }
        Button(onClick = {
            navigateToProfile()
        }) {
            Text(text = "Go to Profile")
        }
        Button(onClick = {
            navigateBack()
        }) {
            Text(text = "Back")
        }
    }
}
