package com.projectBase.ui.home

import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaBaseState

data class HomeViewState(
    val title: String = STRING_EMPTY,
) : EmaBaseState
