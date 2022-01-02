package com.rmygym.presentation.ui.home.adapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmygym.R
import com.rmygym.presentation.model.MuscleExerciseModel

@Composable
fun HomeExerciseItem(item: MuscleExerciseModel) {
    Column() {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = stringResource(
                id = R.string.app_name
            ), modifier = Modifier
                .width(46.dp)
                .height(46.dp)
                .background(color = colorResource(id = R.color.white))
        )
        Text(
            text = item.title,
            modifier = Modifier.padding(4.dp)
//                .background(painterResource(id = R.drawable.bg_item_home_exercise))
        )
        Text(text = item.weight.toString(), Modifier.padding(8.dp), color = colorResource(id = R.color.white))
    }
}