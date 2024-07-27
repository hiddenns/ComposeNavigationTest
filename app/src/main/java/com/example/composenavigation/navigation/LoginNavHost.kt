package com.example.composenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.screens.LoginScreen
import com.example.composenavigation.screens.RegisterScreen
import com.example.composenavigation.screens.ResetPasswordScreen

private sealed class LoginNavigationItem(val route: String) {
    data object ResetPassword : LoginNavigationItem(route = "ResetPassword_route")
    data object Register : LoginNavigationItem(route = "Register_route")
    data object Login : LoginNavigationItem(route = "Login_page_route")
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
            LoginScreen(
                navigateToRegister = { navController.navigate(LoginNavigationItem.Register.route) },
                navigateToResetPassword = { navController.navigate(LoginNavigationItem.ResetPassword.route) }
            )
        }
        composable(LoginNavigationItem.Register.route) {
            RegisterScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(LoginNavigationItem.ResetPassword.route) {
            ResetPasswordScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}