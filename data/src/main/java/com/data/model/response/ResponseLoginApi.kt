package com.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResponseLoginApi(
    @SerializedName("username")
    val username: String?,
    @SerializedName("objectId")
    val id: String?,
    @SerializedName("email")
    val email: String?,
) : Serializable