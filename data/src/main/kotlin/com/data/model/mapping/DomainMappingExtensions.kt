package com.data.model.mapping

import com.data.model.response.ResponseLoginApi
import com.domain.checkNull
import com.domain.model.response.ResponseLoginModel

fun ResponseLoginApi.toDomainModel() = ResponseLoginModel(
    username = username.checkNull(),
    id = id.checkNull(),
    email = email.checkNull()
)