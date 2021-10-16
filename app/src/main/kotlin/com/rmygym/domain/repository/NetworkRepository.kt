package com.rmygym.domain.repository

interface NetworkRepository {
    suspend fun login(request: RequestLoginModel)
    suspend fun register(request: RequestRegisterModel)
}
