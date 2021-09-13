package com.arvind.jetinsta.navigation

import android.annotation.SuppressLint

sealed class Screen(val route: String) {
    @SuppressLint("CustomSplashScreen")
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")
    object ChatListScreen : Screen("chat_list_screen")
    object AddToCartScreen : Screen("add_to_cart_screen")
    object CheckoutScreen : Screen("Checkout_screen")

}