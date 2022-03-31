package com.domain.model.request

import com.carmabs.ema.core.constants.STRING_EMPTY
import java.io.Serializable

data class RequestRegisterModel(
    val email: String = STRING_EMPTY,
    val password: String = STRING_EMPTY,
    val name: String = STRING_EMPTY,
    val firstSurname: String = STRING_EMPTY,
    val secondSurname: String = STRING_EMPTY,
    val username: String = STRING_EMPTY,
    val age: String = STRING_EMPTY,
    val height: String = STRING_EMPTY,
    val weight: String = STRING_EMPTY,
) : Serializable