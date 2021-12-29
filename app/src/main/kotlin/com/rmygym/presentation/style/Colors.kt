package com.rmygym.presentation.style

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val OrangeRmyGym = Color(0xffE29F3B)

private val Blue200 = Color(0xff91a4fc)
private val background = Color.White

val DarkColors = darkColors(
    primary = OrangeRmyGym,
    secondary = Blue200,
    background = background
)
val LightColors = lightColors(
    primary = OrangeRmyGym,
    primaryVariant = Blue200,
    secondary = Blue200,
    background = background
)