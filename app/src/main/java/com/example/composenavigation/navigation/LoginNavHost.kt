package com.example.composenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.screen.LoginScreen
import com.example.composenavigation.screen.RegisterScreen
import com.example.composenavigation.screen.ResetPasswordScreen
import com.example.composenavigation.screen.SplashScreen

sealed class LoginNavigationItem(val route: String) {
    data object ResetPassword : AppNavigationItem(route = "ResetPassword_route")
    data object Register : AppNavigationItem(route = "Register_route")
    data object Login : AppNavigationItem(route = "Login_page_route")
}

@Composable
fun LoginNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = LoginNavigationItem.Login.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(LoginNavigationItem.Login.route) {
            LoginScreen(navController)
        }
        composable(LoginNavigationItem.Register.route) {
            RegisterScreen(navController)
        }
        composable(LoginNavigationItem.ResetPassword.route) {
            ResetPasswordScreen(navController)
        }
    }
}