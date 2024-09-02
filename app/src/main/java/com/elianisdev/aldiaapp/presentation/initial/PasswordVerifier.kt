package com.elianisdev.aldiaapp.presentation.initial

import java.util.Locale

fun verifyPassword(
    username: String,
    password: String,
    result : (Boolean) -> Unit
) {
    //Don't overthink : Just returning true if username and password are equal

    result(
        username.trim().lowercase(Locale.ROOT)
                == password.trim().lowercase(Locale.ROOT)
    )
}