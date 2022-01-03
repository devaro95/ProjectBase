package com.rmygym.presentation.ui.custom.selector

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rmygym.presentation.model.MuscleExerciseModel
import com.rmygym.presentation.ui.home.adapter.HomeExerciseItem
import androidx.compose.foundation.lazy.items

@Composable
fun CustomSelectorExerciseView(items: MutableList<MuscleExerciseModel>) {
    Text(text = "Title muscles group")
    LazyColumn() {
        items(
            items = items,
            itemContent = { SelectorGroupItem(it) }
        )
    }
}