package com.elianisdev.aldiaapp.presentation.initial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elianisdev.aldiaapp.ui.theme.Black
import com.elianisdev.aldiaapp.ui.theme.Gray
import com.elianisdev.aldiaapp.ui.theme.Green
import com.elianisdev.aldiaapp.R.drawable as MyDrawables

@Composable
fun InitialScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Gray,
                        Black
                    ),
                    startY = 0f,
                    endY = 600f
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally


    ){
        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(id = MyDrawables.spotify) ,
            contentDescription = "",
            modifier = Modifier.clip(CircleShape)
            )
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Millions of songs.",
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
            )
        Text(text = "Free on Spotify",
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
            )

        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { }, modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Green
            )
        ) {
            Text(text = "Sign up free",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
                )

        }

    }
}

