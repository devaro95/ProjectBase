package com.rmygym.data.repository

import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.rmygym.domain.exceptions.BaseException
import com.rmygym.domain.exceptions.Login.InvalidCredentialsException
import com.rmygym.domain.exceptions.UnknownException

fun Exception.handleError(): BaseException {
    return when (this) {
        is FirebaseAuthInvalidCredentialsException, is FirebaseAuthInvalidUserException -> InvalidCredentialsException()
        else -> UnknownException()
    }
}