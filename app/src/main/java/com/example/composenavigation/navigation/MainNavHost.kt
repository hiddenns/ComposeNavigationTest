package com.example.composenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composenavigation.screen.SplashScreen

sealed class AppNavigationItem(val route: String) {
    data object Splash : AppNavigationItem(route = "splash_route")
    data object Login : AppNavigationItem(route = "login_route")
}

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = AppNavigationItem.Splash.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppNavigationItem.Splash.route) {
            SplashScreen(
                navigateToLogin = {
                    navController.navigate(route = AppNavigationItem.Login.route)
                }
            )
        }
        composable(AppNavigationItem.Login.route) {
            LoginNavHost()
        }
    }
}