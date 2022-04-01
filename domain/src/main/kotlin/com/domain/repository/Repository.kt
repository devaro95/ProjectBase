package com.domain.repository

import com.domain.model.request.RequestLoginModel
import com.domain.model.request.RequestRegisterModel
import com.domain.model.response.ResponseLoginModel

interface Repository {
    suspend fun login(request: RequestLoginModel): ResponseLoginModel
    suspend fun register(request: RequestRegisterModel)
}