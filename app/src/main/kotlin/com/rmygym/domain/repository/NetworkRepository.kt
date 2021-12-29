package com.rmygym.domain.repository

import com.rmygym.domain.model.request.RequestLoginModel
import com.rmygym.domain.model.request.RequestRegisterModel

interface NetworkRepository {
    suspend fun login(request: RequestLoginModel)
    suspend fun register(request: RequestRegisterModel)
}
