package com.example.composenavigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composenavigation.screens.HomeScreen
import com.example.composenavigation.screens.ProfileScreen
import com.example.composenavigation.screens.SplashScreen
import com.example.composenavigation.screens.SupportScreen

sealed class AppNavigationItem(val route: String) {
    data object Splash : AppNavigationItem(route = "splash_route")
    data object Login : AppNavigationItem(route = "login_route")

    sealed class BottomNavItem(route: String, val icon: ImageVector, val label: String) : AppNavigationItem(route) {
        data object Home : BottomNavItem(route = "home", icon = Icons.Default.Home, label = "Home")
        data object Support : BottomNavItem(route = "support", icon = Icons.Default.Build, label = "Support")
        data object Profile : BottomNavItem(route = "profile", icon = Icons.Default.Person, label = "Profile")
    }
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
            SplashScreen(navigateToLogin = { navController.navigate(route = AppNavigationItem.Login.route) })
        }
        composable(AppNavigationItem.Login.route) { LoginNavHost() }
        composable(AppNavigationItem.BottomNavItem.Home.route) {
            HomeScreen(
                navigateToSupport = { navController.navigate(AppNavigationItem.BottomNavItem.Support.route) },
                navigateToProfile = { navController.navigate(AppNavigationItem.BottomNavItem.Profile.route) },
                navigateBack = { navController.popBackStack() })
        }
        composable(AppNavigationItem.BottomNavItem.Support.route) {
            SupportScreen(
                navigateToHome = { navController.navigate(AppNavigationItem.BottomNavItem.Home.route) },
                navigateToProfile = { navController.navigate(AppNavigationItem.BottomNavItem.Profile.route) }, navigateBack = { navController.popBackStack() }
            )
        }
        composable(AppNavigationItem.BottomNavItem.Profile.route) {
            ProfileScreen(
                navigateToHome = { navController.navigate(route = AppNavigationItem.BottomNavItem.Home.route) },
                navigateToSupport = { navController.navigate(route = AppNavigationItem.BottomNavItem.Support.route) }, navigateBack = { navController.popBackStack() }
            )
        }
    }
}