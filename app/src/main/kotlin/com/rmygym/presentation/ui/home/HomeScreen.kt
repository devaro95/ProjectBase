package com.rmygym.presentation.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rmygym.presentation.model.MuscleExerciseModel
import com.rmygym.presentation.ui.home.adapter.HomeExerciseItem

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(HomeState())
}

@Composable
fun HomeScreen(homeState: HomeState) {
    LazyColumn() {
        items(
            items = homeState.listExercises.toList(),
            itemContent = { HomeExerciseItem(it) }
        )
    }
}