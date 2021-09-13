package com.arvind.jetinsta.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arvind.jetinsta.components.AppBottomNavigation
import com.arvind.jetinsta.components.ChatListItem
import com.arvind.jetinsta.view.InstaChatListScreen
import com.arvind.jetinsta.view.SplashScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.HomeScreen.route) {
            AppBottomNavigation(navController = navController)
        }
        composable(Screen.ChatListScreen.route) {
           InstaChatListScreen()
        }




    }
}