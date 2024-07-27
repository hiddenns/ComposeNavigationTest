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
fun HomeScreen(
    navigateToSupport: () -> Unit,
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
            navigateToSupport()
        }) {
            Text(text = "Go to support")
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
