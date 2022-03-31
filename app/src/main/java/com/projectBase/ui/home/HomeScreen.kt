package com.projectBase.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.domain.model.MuscleExerciseModel
import com.domain.model.MuscleExerciseModel.MuscleGroupType.CHEST
import com.projectBase.R

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        HomeState(listExercises = mutableListOf(
            MuscleExerciseModel(CHEST, "", 0, 0.0),
            MuscleExerciseModel(CHEST, "", 0, 0.0),
            MuscleExerciseModel(CHEST, "", 0, 0.0),
            MuscleExerciseModel(CHEST, "", 0, 0.0),
            MuscleExerciseModel(CHEST, "", 0, 0.0),
            MuscleExerciseModel(CHEST, "", 0, 0.0))
        )
    )
}

@Preview
@Composable
fun ExerciseCardPreview() {
    ExerciseCard()
}

@Composable
fun HomeScreen(homeState: HomeState) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(homeState.listExercises) {
            ExerciseCard()
        }
    }
}

@Composable
fun ExerciseCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.height(80.dp)) {
            Row(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Divider(modifier = Modifier
                    .fillMaxHeight()
                    .width(8.dp), color = Color.Black)
                Image(modifier = Modifier
                    .padding(start = 16.dp)
                    .size(32.dp), painter = painterResource(R.drawable.weight), contentDescription = null)
            }
            Row(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(end = 21.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text(modifier = Modifier.padding(start = 16.dp), text = "Press Banca")
                Text(modifier = Modifier.padding(start = 16.dp), text = "120")
                Text(modifier = Modifier.padding(start = 4.dp), text = "Kg")
            }
        }
    }
}