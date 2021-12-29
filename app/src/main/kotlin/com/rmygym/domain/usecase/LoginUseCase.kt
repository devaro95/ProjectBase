package com.rmygym.domain.usecase

import com.rmygym.domain.model.request.RequestLoginModel
import com.rmygym.domain.repository.NetworkRepository
import es.babel.easymvvm.core.usecase.EmaUseCase

class LoginUseCase(private val repository: NetworkRepository) : EmaUseCase<RequestLoginModel, Unit>() {
    override suspend fun useCaseFunction(input: RequestLoginModel) {
        repository.login(input)
    }
}