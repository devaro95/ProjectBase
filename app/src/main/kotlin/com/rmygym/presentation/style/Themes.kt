package com.rmygym.presentation.style

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun RmyGymTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    colors: Colors? = null,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = colors ?: if (isDarkTheme) DarkColors else LightColors,
        content = content,
        typography = RmyGymTypography
    )
}