package com.data.net.retrofit

import com.data.BuildConfig
import com.data.net.ErrorHandler
import com.data.net.interceptor.AuthorizationHeaderInterceptor
import com.data.net.interceptor.HttpClient
import com.data.net.interceptor.HttpClient.Companion.emptyTrustManager
import com.data.net.interceptor.NoInternetInterceptor
import com.data.net.interceptor.RemoteExceptionInterceptor
import com.data.net.interceptor.TokenHeaderInterceptor
import com.domain.manager.NetworkManager
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitBuilder(
    private val errorHandler: ErrorHandler,
    private val networkManager: NetworkManager,
) {

    private val httpLoggingInterceptor = HttpLoggingInterceptor()
    private var baseUrl: String = DEFAULT_BASE_URL
    private var ignoreSSL: Boolean = true
    private var interceptors: List<Interceptor> = listOf()

    fun createRetrofit(token: String? = null) =
        baseUrl().httpLoggingInterceptorLevel(
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        ).interceptors(generateInterceptors(token)).build()

    private fun baseUrl() = also { builder ->
        builder.baseUrl = BuildConfig.BASE_URL
    }

    private fun httpLoggingInterceptorLevel(level: HttpLoggingInterceptor.Level) = also { builder ->
        builder.httpLoggingInterceptor.level = level
    }

    private fun interceptors(interceptors: List<Interceptor>) = also { builder ->
        builder.interceptors = interceptors
    }

    private fun generateInterceptors(token: String?): List<Interceptor> =
        mutableListOf(
            NoInternetInterceptor(networkManager),
            RemoteExceptionInterceptor(errorHandler),
            AuthorizationHeaderInterceptor()
        ).also {
            token?.run {
                it.add(TokenHeaderInterceptor(this))
            }
        }

    private fun build(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(createGsonConverterFactory())
        .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
        .client(createHttpClient())
        .build()

    private fun createGsonConverterFactory() = GsonConverterFactory.create(
        GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .serializeNulls()
            .create()
    )

    private fun createHttpClient() = HttpClient.Builder()
        .ignoreSSL(ignoreSSL)
        .interceptors(interceptors + httpLoggingInterceptor)
        .trustManagers(listOf(emptyTrustManager))
        .build()

    companion object {
        const val DEFAULT_BASE_URL = ""
    }
}
