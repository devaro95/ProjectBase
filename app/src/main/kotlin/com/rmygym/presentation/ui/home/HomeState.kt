package com.rmygym.presentation.ui.home

import com.rmygym.presentation.model.MuscleExerciseModel
import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

data class HomeState(
    val listExercises: MutableList<MuscleExerciseModel> = mutableListOf()
) : EmaBaseState
