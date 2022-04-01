package com.domain.model.response

import com.carmabs.ema.core.constants.STRING_EMPTY
import java.io.Serializable

class ResponseLoginModel(
    val username: String = STRING_EMPTY,
    val id: String = STRING_EMPTY,
    val email: String = STRING_EMPTY,
) : Serializable