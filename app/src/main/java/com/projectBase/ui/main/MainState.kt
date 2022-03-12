package com.projectBase.ui.main

import com.carmabs.ema.core.state.EmaBaseState

data class MainState(
    val toolbar: Toolbar = Toolbar(),
) : EmaBaseState {
    data class Toolbar(
        val isVisible: Boolean = false,
    )
}
