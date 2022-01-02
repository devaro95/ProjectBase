package com.rmygym.presentation.model

import com.rmygym.R

data class MuscleExerciseModel(
    val type: MuscleGroupType,
    val title: String,
    val icon: Int = R.drawable.ic_exercise_default,
    val weight: Double
)