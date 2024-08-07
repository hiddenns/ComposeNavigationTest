package com.example.composenavigation.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen(
    navigateToSupport: () -> Unit,
    navigateToHome: () -> Unit,
    navigateBack: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profile Screen!")
        Button(onClick = {
            navigateToSupport()
        }) {
            Text(text = "Go to Support")
        }
        Button(onClick = {
            navigateToHome()
        }) {
            Text(text = "Go to Home")
        }
        Button(onClick = {
            navigateBack()
        }) {
            Text(text = "Back")
        }
    }
}
