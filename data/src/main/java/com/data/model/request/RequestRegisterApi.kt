package com.data.model.request

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RequestRegisterApi(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
) : Serializable