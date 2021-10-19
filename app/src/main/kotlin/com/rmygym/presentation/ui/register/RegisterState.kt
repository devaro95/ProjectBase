package com.rmygym.presentation.ui.register

import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

data class RegisterState(
    val email: String = STRING_EMPTY,
    val password: String = STRING_EMPTY,
    val username: String = STRING_EMPTY,
    val name: String = STRING_EMPTY,
    val firstSurname: String = STRING_EMPTY,
    val secondSurname: String = STRING_EMPTY,
    val age: String = STRING_EMPTY,
    val weight: String = STRING_EMPTY,
    val height: String = STRING_EMPTY,
) : EmaBaseState