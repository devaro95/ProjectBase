package com.domain.model

data class MuscleExerciseModel(
    val type: MuscleGroupType,
    val title: String,
    val icon: Int,
    val weight: Double,
) {
    enum class MuscleGroupType {
        CHEST
    }
}