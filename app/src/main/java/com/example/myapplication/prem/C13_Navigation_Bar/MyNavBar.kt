package com.example.myapplication.prem.C13_Navigation_Bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

@Composable
fun MyNavBar(navController: NavHostController) {
    val NavItem = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Search", Icons.Default.Search),
        NavItem("Notifications", Icons.Default.Notifications),
        NavItem("Profile", Icons.Default.Person)
    )

    NavigationBar {

        NavItem.forEach { item ->
            NavigationBarItem(
                selected = true,
                onClick = { },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "Home"
                    )
                },
                label = { Text(text =item.title) }
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: ImageVector
)