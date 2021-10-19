package com.rmygym.data.repository

import com.rmygym.data.model.UserApi
import com.rmygym.domain.model.request.RequestRegisterModel

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

fun RequestRegisterModel.toDataModel() = UserApi(
    name = name,
    username = username,
    email = email,
    height = height,
    weight = weight,
    firstSurname = firstSurname,
    secondSurname = secondSurname,
    age = age
)