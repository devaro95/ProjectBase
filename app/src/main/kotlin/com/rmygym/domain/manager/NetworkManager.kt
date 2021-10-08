package com.rmygym.domain.manager

interface NetworkManager {

    fun isNetworkAvailable(): Boolean

    fun getDeviceIp(): String?
}
