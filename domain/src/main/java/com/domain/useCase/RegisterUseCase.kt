package com.domain.useCase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.domain.model.request.RequestRegisterModel
import com.domain.repository.Repository

class RegisterUseCase(private val repository: Repository) : EmaUseCase<RequestRegisterModel, Unit>() {
    override suspend fun useCaseFunction(input: RequestRegisterModel) = repository.register(input)
}