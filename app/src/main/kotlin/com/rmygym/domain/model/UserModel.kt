package com.rmygym.domain.model

import es.babel.easymvvm.core.constants.STRING_EMPTY
import java.io.Serializable

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

data class UserModel(
    val name: String = STRING_EMPTY
) : Serializable