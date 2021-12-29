package com.rmygym.presentation.ui.login

import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

data class LoginState(
    val email: String = STRING_EMPTY,
    val password: String = STRING_EMPTY
) : EmaBaseState