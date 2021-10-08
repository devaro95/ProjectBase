package com.rmygym.data.net.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationHeaderInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(
        chain.request().newBuilder().addHeader(AUTHORIZATION_HEADER, token).build()
    )

    private companion object {
        const val AUTHORIZATION_HEADER = "Authorization"
    }
}
