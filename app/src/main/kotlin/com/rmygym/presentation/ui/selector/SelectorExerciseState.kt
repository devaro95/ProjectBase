package com.rmygym.presentation.ui.selector

import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

data class SelectorExerciseState(
    val title: String = STRING_EMPTY
) : EmaBaseState
