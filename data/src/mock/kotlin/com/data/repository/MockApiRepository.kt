package com.data.repository

import com.domain.model.request.RequestLoginModel
import com.domain.model.request.RequestRegisterModel
import com.domain.model.response.ResponseLoginModel
import com.domain.repository.Repository

class MockApiRepository : Repository {
    override suspend fun login(request: RequestLoginModel) = ResponseLoginModel(
        username = "Varo",
        id = "1",
        email = "varo@rmygym.com"
    )

    override suspend fun register(request: RequestRegisterModel) = Unit
}

