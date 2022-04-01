package com.domain.useCase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.domain.model.request.RequestLoginModel
import com.domain.model.response.ResponseLoginModel
import com.domain.repository.Repository

class LoginUseCase(private val repository: Repository) : EmaUseCase<RequestLoginModel, ResponseLoginModel>() {
    override suspend fun useCaseFunction(input: RequestLoginModel) = repository.login(input)
}