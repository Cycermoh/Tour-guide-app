package com.maureen.tourguideapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maureen.tourguideapplication.ui.theme.screens.login.LoginScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_LOGIN) {

    NavHost(
        navController = navController,
        modifier = Modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
//        }
//        composable(ROUTE_REGISTER) {
//            RegisterScreen(navController)
//        }
//
        composable(ROUTE_HOME) {
            Homescreen(navController)
        }
//        composable(ROUTE_LOGIN) {
//            LoginScreen(navController)
//        }
//        composable(ROUTE_VIEW_PRODUCT) {
//            ViewProductsScreen(navController)
//        }
//        composable("$ROUTE_UPDATE_PRODUCT/{id}") { passedData ->
//            UpdateProductsScreen(navController, passedData.arguments?.getString("id")!!)
//        }
//        composable(ROUTE_VIEW_UPLOAD) {
//            ViewUploadsScreen(navController)
////        }
//        }
////
////
//
//    }
//}
//
