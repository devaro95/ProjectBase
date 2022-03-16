package com.domain.model.request

import com.carmabs.ema.core.constants.STRING_EMPTY

data class RequestLoginModel(
    val email: String = STRING_EMPTY,
    val password: String = STRING_EMPTY,
)