package com.data.manager

import android.content.Context
import android.net.ConnectivityManager
import com.domain.manager.NetworkManager
import java.net.Inet4Address
import java.net.NetworkInterface

class ContextNetworkManager(private val context: Context) : NetworkManager {

    @Suppress("DEPRECATION")
    override fun isNetworkAvailable(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}
