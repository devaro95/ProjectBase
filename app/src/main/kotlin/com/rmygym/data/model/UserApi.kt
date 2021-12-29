package com.rmygym.data.model

import java.io.Serializable

class UserApi(
    val username: String,
    val email: String,
    val name: String,
    val firstSurname: String,
    val secondSurname: String,
    val age: String,
    val height: String,
    val weight: String
) : Serializable