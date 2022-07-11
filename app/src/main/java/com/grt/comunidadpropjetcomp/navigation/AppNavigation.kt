package com.grt.comunidadpropjetcomp.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grt.comunidadpropjetcomp.ui.loginComunity.ComunityViewModel
import com.grt.comunidadpropjetcomp.ui.screen.*

/**
 * Created por Gema Rosas Trujillo
 * 16/06/2022
 */

@Composable
fun AppNavigation(context: Context) {

    val navController = rememberNavController()
    val viewModel = hiltViewModel<ComunityViewModel>()

    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ){

        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreens.MainScreen.route){
            MainScreen(context,navController, viewModel)
        }
        composable(NavigationItem.Info.route){
            InfoScreen(context, navController, viewModel)
        }
        composable(NavigationItem.Normas.route) {
            NormasScreen(context, navController, viewModel)
        }
        composable(NavigationItem.Interes.route) {
            InteresScreen(context, navController, viewModel)
        }
    }
}