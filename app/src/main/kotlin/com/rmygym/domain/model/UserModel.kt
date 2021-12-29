package com.rmygym.domain.model

import es.babel.easymvvm.core.constants.STRING_EMPTY
import java.io.Serializable

data class UserModel(
    val name: String = STRING_EMPTY,
    val firstSurname: String = STRING_EMPTY,
    val secondSurname: String = STRING_EMPTY,
    val username: String = STRING_EMPTY,
    val email: String = STRING_EMPTY,
) : Serializable