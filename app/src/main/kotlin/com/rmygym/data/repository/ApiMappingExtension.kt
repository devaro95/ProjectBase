package com.rmygym.data.repository

import com.google.firebase.auth.FirebaseUser
import com.rmygym.domain.model.UserModel
import es.babel.easymvvm.core.extension.checkNull

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

fun FirebaseUser.toDomainModel() = UserModel(
    name = displayName.checkNull()
)