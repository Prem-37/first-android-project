package com.example.myapplication.prem.C_10_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun NavGraph() {

    // navController -> Handle Navigation
    // rememberNavController -> Create & remember navController

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MyNavRoutes.LoginScreen
    ){

        composable<MyNavRoutes.LoginScreen>{
            LoginScreenUI(navController)
        }

        composable<MyNavRoutes.HomeScreen>{
            HomeScreenUI(NavController)
        }

        // backStackEntry is a lambda function having
        // data and arguments which are passed during Navigation

        composable<MyNavRoutes.WelcomeScreen> {backStackEntry ->
            val data = backStackEntry.toRoute<MyNavRoutes.WelcomeScreen>()
            WelcomeScreenUI(data.userName, navController)
        }
    }
}