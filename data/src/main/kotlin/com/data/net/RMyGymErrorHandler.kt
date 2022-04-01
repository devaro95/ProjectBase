package com.data.net

import com.domain.exception.UnknownException
import okhttp3.Response
import java.net.HttpURLConnection.HTTP_BAD_REQUEST
import java.net.HttpURLConnection.HTTP_FORBIDDEN
import java.net.HttpURLConnection.HTTP_NOT_FOUND
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED

class RMyGymErrorHandler : ErrorHandler {

    override fun handleError(response: Response): Throwable {
        response.code.apply {
            return when {
                else -> UnknownException()
            }
        }
    }

    private fun Int.isUnauthorized() = isResponseCode(HTTP_UNAUTHORIZED)

    private fun Int.isBadRequest() = isResponseCode(HTTP_BAD_REQUEST)

    private fun Int.isForbiddenAccess() = isResponseCode(HTTP_FORBIDDEN)

    private fun Int.isNotFound() = isResponseCode(HTTP_NOT_FOUND)

    private fun Int.isResponseCode(httUrlConnection: Int) = this == httUrlConnection
}
