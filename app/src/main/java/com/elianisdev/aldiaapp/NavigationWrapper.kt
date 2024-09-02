package com.elianisdev.aldiaapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavigationWrapper(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "initial" ){

        // Add the routes here
        composable

    }

}