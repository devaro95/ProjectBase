package com.rmygym.presentation.ui.main

import es.babel.easymvvm.core.state.EmaBaseState

data class MainViewState(
    val toolbar: Toolbar = Toolbar()
) : EmaBaseState {
    data class Toolbar(
        val isVisible: Boolean = false
    )
}
