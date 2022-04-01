package com.data.net.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class TokenHeaderInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(
        chain.request().newBuilder().addHeader(HEADER_TOKEN, token).build()
    )

    private companion object {
        const val HEADER_TOKEN = "X-Parse-Session-Token"
    }
}
