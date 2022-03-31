package com.domain.repository

import com.domain.model.request.RequestLoginModel
import com.domain.model.request.RequestRegisterModel

interface Repository {
    suspend fun login(request: RequestLoginModel)
    suspend fun register(request: RequestRegisterModel)
}