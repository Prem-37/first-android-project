package com.example.myapplication.prem.C13_Navigation_Bar

import android.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

@Composable
fun MyNavBar(navController: NavHostController, key: String) {
    val NavItem = listOf(
        NavItem("Home", Icons.Default.Home, NavBarRoutes.Home),
        NavItem("Search", Icons.Default.Search, NavBarRoutes.Search),
        NavItem("Notifications", Icons.Default.Notifications, NavBarRoutes.Notification),
        NavItem("Profile", Icons.Default.Person, NavBarRoutes.Profile)
    )

    NavigationBar {

        NavItem.forEach { item ->
            NavigationBarItem(
                selected = item.title == key,
                onClick = {
                    navController.navigate(item.routes) {
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "Home"
                    )
                },
                label = { Text(text = item.title) },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = Color.Blue,
                    selectedIconColor = Color.Blue,
                    indicatorColor = Color.Blue.copy(alpha = 0.1f),
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray
                )
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: ImageVector,
    val routes: NavBarRoutes
)