package com.grt.comunidadpropjetcomp.navigation

/**
 * Created por Gema Rosas Trujillo
 * 16/06/2022
 */
sealed class AppScreens(val route: String) {
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")
}