package com.rmygym.presentation.model

data class ActivityResultHandlerModel(
    val id: Int,
    val implementation: ((Int, Result, Any?) -> Boolean) // Return true if it's removed after being used
) {
    sealed class Result(val code: Int) {

        object Success : Result(SUCCESS_CODE)

        object Fail : Result(FAIL_CODE)

        class Other(code: Int) : Result(code)
    }

    companion object {
        const val SUCCESS_CODE = -1
        const val FAIL_CODE = 0
    }
}
