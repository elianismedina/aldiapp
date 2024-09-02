package com.elianisdev.aldiaapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elianisdev.aldiaapp.presentation.home.HomeScreen
import com.elianisdev.aldiaapp.presentation.initial.InitialScreen
import com.elianisdev.aldiaapp.presentation.login.LoginScreen
import com.elianisdev.aldiaapp.presentation.signup.SignupScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavigationWrapper(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    auth: FirebaseAuth
) {
    NavHost(navController = navHostController, startDestination = "initial") {

        composable("initial") {
            InitialScreen(
                navigateToLogin = {
                    navHostController.navigate("logIn")
                },
                navigateToSignup = {
                    navHostController.navigate("signUp")
                }
            )
        }
        composable("logIn") {
            LoginScreen(auth = auth) {
                navHostController.navigate("home")
            }
        }
        composable("signUp") {
            SignupScreen(auth = auth)

        }
        composable("home") {
            HomeScreen()
        }

    }
}