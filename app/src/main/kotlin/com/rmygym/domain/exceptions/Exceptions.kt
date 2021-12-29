package com.rmygym.domain.exceptions

object Login {
    class InvalidCredentialsException : BaseException()
}

object Register {
    class UsernameExistsException : BaseException()
}
