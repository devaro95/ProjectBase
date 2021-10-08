package com.rmygym.data.net

import okhttp3.Response

interface ErrorHandler {
    fun handleError(response: Response): Throwable
}
