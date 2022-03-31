package com.projectBase.ui.selector

import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaBaseState

data class SelectorExerciseState(
    val title: String = STRING_EMPTY,
) : EmaBaseState
