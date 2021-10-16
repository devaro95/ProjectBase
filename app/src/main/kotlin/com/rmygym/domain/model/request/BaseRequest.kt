package com.rmygym.domain.model.request

import java.lang.Exception

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

interface BaseRequest{
    val onSuccess: ((Any?) -> Unit)?
    val onError: ((Exception) -> Unit)?
}
