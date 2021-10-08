package com.rmygym.data.repository

import com.rmygym.BuildConfig
import com.rmygym.Environment
import com.rmygym.data.net.ErrorHandler
import com.rmygym.data.net.RMyGymApi
import com.rmygym.data.net.Retrofit
import com.rmygym.data.net.interceptor.AuthorizationHeaderInterceptor
import com.rmygym.data.net.interceptor.NoInternetInterceptor
import com.rmygym.data.net.interceptor.RemoteExceptionInterceptor
import com.rmygym.domain.manager.NetworkManager
import com.rmygym.domain.repository.NetworkRepository
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class NetworkRepository(
    private val networkManager: NetworkManager,
    private val errorHandler: ErrorHandler
) : NetworkRepository {

    private lateinit var rmyGymAPI: RMyGymApi

    /**
     * Retrofit initialization
     */

    private var retrofit: retrofit2.Retrofit = createRetrofit()
        set(value) {
            field = value
            rmyGymAPI = field.create(RMyGymApi::class.java)
        }

    init {
        retrofit = createRetrofit()
    }

    private fun createRetrofit(token: String? = null): retrofit2.Retrofit =
        Retrofit.Builder()
            .baseUrl(Environment.RMyGymApi.BASE_URL)
            .ignoreSSL(Environment.RMyGymApi.IGNORE_SSL)
            .httpLoggingInterceptorLevel(
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            )
            .interceptors(generateInterceptors(token))
            .build()

    private fun generateInterceptors(token: String?): List<Interceptor> =
        mutableListOf(
            NoInternetInterceptor(networkManager),
            RemoteExceptionInterceptor(errorHandler)
        ).also {
            token?.run { it.add(AuthorizationHeaderInterceptor(token)) }
        }

    /**
     * Repository functions
     */
}
