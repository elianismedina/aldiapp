package com.elianisdev.aldiaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold

import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.elianisdev.aldiaapp.ui.theme.AlDiaAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navHostController = rememberNavController()

            AlDiaAppTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    NavigationWrapper(
                        modifier = Modifier.padding(innerPadding),
                        navHostController = navHostController


                    )
                }
            }
        }
    }
}

