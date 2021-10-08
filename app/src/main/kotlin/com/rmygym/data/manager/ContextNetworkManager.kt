package com.rmygym.data.manager

import android.content.Context
import android.net.ConnectivityManager
import com.rmygym.domain.manager.NetworkManager
import java.net.Inet4Address
import java.net.NetworkInterface

class ContextNetworkManager(private val context: Context) : NetworkManager {

    @Suppress("DEPRECATION")
    override fun isNetworkAvailable(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    override fun getDeviceIp(): String? =
        kotlin.runCatching {
            val networkInterfaces = NetworkInterface.getNetworkInterfaces()
            while (networkInterfaces.hasMoreElements()) {
                val networkInterface = networkInterfaces.nextElement()
                val inetAddresses = networkInterface.inetAddresses
                while (inetAddresses.hasMoreElements()) {
                    val inetAddress = inetAddresses.nextElement()
                    if (inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                        return inetAddress.hostAddress
                    }
                }
            }
            return null
        }.getOrNull()
}
