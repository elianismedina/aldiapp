package com.elianisdev.aldiaapp.presentation.login

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.elianisdev.aldiaapp.presentation.initial.components.CustomTextField
import com.elianisdev.aldiaapp.presentation.initial.components.PasswordTextField
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.elianisdev.aldiaapp.R.drawable as myDrawables
import com.elianisdev.aldiaapp.ui.theme.Black
import com.elianisdev.aldiaapp.ui.theme.Gray
import com.elianisdev.aldiaapp.ui.theme.onPrimaryLight
import com.elianisdev.aldiaapp.ui.theme.primaryLight

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    auth: FirebaseAuth,
    navigateToHome: () -> Unit
) {
    LoginPageBody {
        LoginPageContent(auth = auth)
        
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginPageBody(
    content: @Composable (PaddingValues) -> Unit,
    
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        content = {
            content(it)
        }
    )
}

@Composable
private fun LoginPageContent(
    auth: FirebaseAuth
) {
    ConstraintLayout(
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

            )
    ) {

        //creating References for each composable for
        //we are going to use inside this constraint Layout
        val (
            headerImage, headerTitle,
            usernameTextField, passwordTextField,
            loginBtn, forgotPassword
        ) = createRefs()

        //values for textFields
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        var isLoginSuccess by remember {
            mutableStateOf(false)
        }

        //Guidelines for our constraint layout
        val leftGuideline = createGuidelineFromStart(offset = 15.dp)
        val rightGuideline = createGuidelineFromEnd(offset = 15.dp)
        val topGuideline = createGuidelineFromTop(offset = 15.dp)
        val bottomGuideline = createGuidelineFromBottom(offset = 15.dp)

        //we dividing the layout in 2 parts
        //one for the header
        //another for the buttons and textFields
        val centerGuideLine = createGuidelineFromTop(.5f)


        //Box for holding the image
        Box(
            modifier = Modifier
                .fillMaxWidth(.7f)
                .height(150.dp)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .constrainAs(headerImage) {
                    start.linkTo(leftGuideline)
                    end.linkTo(rightGuideline)
                    top.linkTo(topGuideline)
                    bottom.linkTo(centerGuideLine)
                }
        ) {
            Crossfade(targetState = isLoginSuccess, label = "") { isSuccess ->
                Image(
                    painter = if (isSuccess) painterResource(id = myDrawables.youaregoddamnright)
                    else painterResource(id = myDrawables.saymyname),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
        }

        //Header text that says Login page
        Text(
            text = "Login page",
            modifier = Modifier.constrainAs(headerTitle) {
                top.linkTo(headerImage.bottom, 20.dp)
                start.linkTo(headerImage.start)
                end.linkTo(headerImage.end)
            },
            color = onPrimaryLight,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        //TextField for username
        CustomTextField(
            value = username,
            label = "usuario",
            leadingIcon = Icons.Rounded.Person,
            onValueChange = {
                username = it
            },
            modifier = Modifier.constrainAs(usernameTextField) {
                top.linkTo(centerGuideLine)
                centerHorizontallyTo(parent, .5f)
            }
        )

        //TextField for password
        PasswordTextField(
            value = password,
            label = "contraseña",
            leadingIcon = Icons.Rounded.Lock,
            onValueChange = {
                password = it
            },
            modifier = Modifier.constrainAs(passwordTextField) {
                top.linkTo(usernameTextField.bottom, 15.dp)
                centerHorizontallyTo(parent, .5f)
            },




        )

        //Button for login
        Button(
            onClick = {
            auth.signInWithEmailAndPassword(
                username,
                password

            ).addOnCompleteListener{
                task ->
                if (task.isSuccessful){
                    Log.i("ElianisDev", "LOGIN OK")
                }else{
                    Log.i("ElianisDev", "LOGIN KO")
                }
            }
            },


            colors = ButtonDefaults.buttonColors(
                containerColor = primaryLight
            ),
            modifier = Modifier
                .fillMaxWidth(.6f)
                .height(55.dp)
                .constrainAs(loginBtn) {
                    top.linkTo(passwordTextField.bottom, margin = 40.dp)
                    start.linkTo(passwordTextField.start)
                    end.linkTo(passwordTextField.end)
                }

        ) {
            Text(
                text = "Iniciar sesión",
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )
        }

        //text for forgot password
        Text(
            text = "¿Olvidaste tu contraseña?",
            modifier = Modifier.constrainAs(forgotPassword) {
                top.linkTo(loginBtn.bottom, margin = 20.dp)
                start.linkTo(loginBtn.start)
                end.linkTo(loginBtn.end)
            },
            color = onPrimaryLight
        )
    }
}