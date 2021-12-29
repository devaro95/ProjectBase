package com.rmygym.data.repository

import com.rmygym.data.model.UserApi
import com.rmygym.domain.model.request.RequestRegisterModel

fun RequestRegisterModel.toDataModel() = UserApi(
    name = name,
    username = username,
    email = email,
    height = height,
    weight = weight,
    firstSurname = firstSurname,
    secondSurname = secondSurname,
    age = age
)