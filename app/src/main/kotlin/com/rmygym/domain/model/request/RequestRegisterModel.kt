package com.rmygym.domain.model.request

import es.babel.easymvvm.core.constants.STRING_EMPTY
import java.io.Serializable
import java.lang.Exception

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

data class RequestRegisterModel(
    val email: String = STRING_EMPTY,
    val password: String = STRING_EMPTY,
    val name: String = STRING_EMPTY,
    val age: String = STRING_EMPTY,
    val height: String = STRING_EMPTY,
    val weight: String = STRING_EMPTY,
    override val onSuccess: ((Any?) -> Unit)?,
    override val onError: ((Exception) -> Unit)?,
) : BaseRequest
