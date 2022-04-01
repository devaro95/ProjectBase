package com.data.net.interceptor

import com.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationHeaderInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(
        chain.request().newBuilder()
            .addHeader(HEADER_API_APPLICATION_ID, BuildConfig.APPLICATION_ID)
            .addHeader(HEADER_API_KEY, BuildConfig.API_KEY).build()
    )

    private companion object {
        const val HEADER_API_APPLICATION_ID = "X-Parse-Application-Id"
        const val HEADER_API_KEY = "X-Parse-REST-API-Key"
    }
}
