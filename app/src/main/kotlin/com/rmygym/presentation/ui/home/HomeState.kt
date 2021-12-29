package com.rmygym.presentation.ui.home

import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

data class HomeState(
    val title: String = STRING_EMPTY
) : EmaBaseState
