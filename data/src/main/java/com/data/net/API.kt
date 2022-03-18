package com.data.net

import com.data.model.request.RequestRegisterApi
import com.data.model.response.ResponseLoginApi
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface API {

    @POST("users")
    suspend fun register(@Body request: RequestRegisterApi)

    @GET("login")
    suspend fun login(@Query(value = "username") username: String, @Query(value = "password") password: String): ResponseLoginApi

}