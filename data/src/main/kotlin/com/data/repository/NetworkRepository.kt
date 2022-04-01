package com.data.repository

import com.data.model.mapping.toDataModel
import com.data.model.mapping.toDomainModel
import com.data.net.API
import com.data.net.ErrorHandler
import com.data.net.retrofit.RetrofitBuilder
import com.domain.manager.NetworkManager
import com.domain.model.request.RequestLoginModel
import com.domain.model.request.RequestRegisterModel
import com.domain.model.response.ResponseLoginModel
import com.domain.repository.Repository

class NetworkRepository(
    private val errorHandler: ErrorHandler,
    private val networkManager: NetworkManager,
) : Repository {

    private lateinit var api: API

    private fun createRetrofit(token: String? = null) = RetrofitBuilder(errorHandler, networkManager).createRetrofit(token)

    private var retrofit: retrofit2.Retrofit = createRetrofit()
        set(value) {
            field = value
            api = field.create(API::class.java)
        }

    init {
        retrofit = createRetrofit()
    }

    override suspend fun login(request: RequestLoginModel): ResponseLoginModel {
        request.toDataModel().run {
            return api.login(username, password).toDomainModel()
        }
    }

    override suspend fun register(request: RequestRegisterModel) {
        api.register(request.toDataModel())
    }
}