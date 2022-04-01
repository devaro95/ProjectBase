package com.data.model.mapping

import com.data.model.request.RequestLoginApi
import com.data.model.request.RequestRegisterApi
import com.domain.model.request.RequestLoginModel
import com.domain.model.request.RequestRegisterModel

fun RequestRegisterModel.toDataModel() = RequestRegisterApi(
    username = username,
    password = password
)

fun RequestLoginModel.toDataModel() = RequestLoginApi(
    username = username,
    password = password
)