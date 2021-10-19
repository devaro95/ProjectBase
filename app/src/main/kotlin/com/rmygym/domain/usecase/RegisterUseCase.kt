package com.rmygym.domain.usecase

import com.rmygym.domain.model.request.RequestRegisterModel
import com.rmygym.domain.repository.NetworkRepository
import es.babel.easymvvm.core.usecase.EmaUseCase

class RegisterUseCase(private val repository: NetworkRepository) : EmaUseCase<RequestRegisterModel, Unit>() {
    override suspend fun useCaseFunction(input: RequestRegisterModel) {
        repository.register(input)
    }
}