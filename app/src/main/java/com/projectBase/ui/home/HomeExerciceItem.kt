package com.projectBase.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.domain.model.MuscleExerciseModel
import com.projectBase.R


@Composable
fun HomeExerciseItem(item: MuscleExerciseModel) {
    Column() {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            modifier = Modifier
                .width(46.dp)
                .height(46.dp)
                .background(color = colorResource(id = R.color.white))
        )
        Text(
            text = item.title,
            modifier = Modifier.padding(4.dp)
        )
        Text(text = item.weight.toString(), Modifier.padding(8.dp), color = colorResource(id = R.color.white))
    }
}