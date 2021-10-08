package com.rmygym.data.net

import com.rmygym.domain.exceptions.BadRequestException
import com.rmygym.domain.exceptions.InternalServerException
import com.rmygym.domain.exceptions.InvalidCredentialsException
import com.rmygym.domain.exceptions.UnknownException
import okhttp3.Response
import java.net.HttpURLConnection

class RmyGymErrorHandler : ErrorHandler {

    override fun handleError(response: Response): Throwable {
        return when (response.code) {
            HttpURLConnection.HTTP_UNAUTHORIZED -> InvalidCredentialsException()
            HttpURLConnection.HTTP_BAD_REQUEST -> BadRequestException()
            HttpURLConnection.HTTP_INTERNAL_ERROR -> InternalServerException()
            else -> UnknownException()
        }
    }
}
