package com.data.repository

import com.domain.model.request.RequestLoginModel
import com.domain.model.request.RequestRegisterModel
import com.domain.repository.Repository

class NetworkRepository : Repository {
    override suspend fun login(request: RequestLoginModel) {

    }

    override suspend fun register(request: RequestRegisterModel) {

    }
}