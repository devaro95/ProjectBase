package com.projectBase.ui.home

import com.carmabs.ema.core.state.EmaBaseState
import com.domain.model.MuscleExerciseModel

data class HomeState(
    val listExercises: MutableList<MuscleExerciseModel> = mutableListOf(),
) : EmaBaseState
