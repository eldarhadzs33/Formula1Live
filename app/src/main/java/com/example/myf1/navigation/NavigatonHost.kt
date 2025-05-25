package com.example.myf1.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myf1.ui.screen.DriversListScreen
import com.example.myf1.ui.screen.HomeScreen

@Composable
fun NavigatonHost(){
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination="/home"){
        composable("/home") { HomeScreen(navController) }
        composable("/drivers"){DriversListScreen(
            viewModel = viewModel(),
            navController = navController
        )}
    }
}