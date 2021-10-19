package com.rmygym.presentation.ui.login

import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

data class LoginState(
    val email: String = STRING_EMPTY,
    val password: String = STRING_EMPTY
) : EmaBaseState