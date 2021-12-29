package com.rmygym.domain.model.request

import es.babel.easymvvm.core.constants.STRING_EMPTY
import java.lang.Exception

data class RequestLoginModel(
    val email: String = STRING_EMPTY,
    val password: String = STRING_EMPTY,
    override val onSuccess: ((Any?) -> Unit)?,
    override val onError: ((Exception) -> Unit)?,
) : BaseRequest
