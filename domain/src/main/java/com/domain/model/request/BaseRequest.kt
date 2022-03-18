package com.domain.model.request

import java.lang.Exception

interface BaseRequest{
    val onSuccess: ((Any?) -> Unit)?
    val onError: ((Exception) -> Unit)?
}
