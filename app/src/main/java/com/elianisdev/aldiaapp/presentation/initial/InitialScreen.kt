package com.elianisdev.aldiaapp.presentation.initial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.elianisdev.aldiaapp.ui.theme.Black
import com.elianisdev.aldiaapp.ui.theme.Gray

@Composable
fun InitialScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(
                Gray,
                Black
            )))
    ){

    }
}

