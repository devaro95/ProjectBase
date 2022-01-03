package com.rmygym.presentation.ui.custom.selector

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rmygym.R
import com.rmygym.presentation.model.MuscleExerciseModel

@Composable
fun SelectorGroupItem(item: MuscleExerciseModel) {
    Column() {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = "Prueba",
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .background(color = colorResource(id = R.color.black))
        )
        Text(text = item.title, Modifier.size(20.dp))
        //Cambiar a textSize
    }
}
