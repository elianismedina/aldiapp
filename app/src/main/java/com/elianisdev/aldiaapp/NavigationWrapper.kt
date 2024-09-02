package com.elianisdev.aldiaapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elianisdev.aldiaapp.presentation.initial.InitialScreen
import com.elianisdev.aldiaapp.presentation.login.LoginScreen
import com.elianisdev.aldiaapp.presentation.signup.SignupScreen

@Composable
fun NavigationWrapper(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "initial") {

        composable("initial") {
            InitialScreen(
                navigateToLogin = {
                    navHostController.navigate("LogIn")
                },
                navigateToSignup = {
                    navHostController.navigate("SignUp")
                }
            )
        }
        composable("LogIn") {
            LoginScreen()
        }
        composable("SignUp") {
            SignupScreen()

        }

    }
}