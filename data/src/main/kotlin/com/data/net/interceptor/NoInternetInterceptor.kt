package com.data.net.interceptor

import com.domain.exception.NoInternetException
import com.domain.manager.NetworkManager
import okhttp3.Interceptor
import okhttp3.Response

class NoInternetInterceptor(private val networkManager: NetworkManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkManager.isNetworkAvailable()) {
            throw NoInternetException()
        }
        return chain.proceed(chain.request())
    }
}
