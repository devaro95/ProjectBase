package com.projectBase.ui.login

import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaBaseState

data class LoginState(
    val username: String = STRING_EMPTY,
    val password: String = STRING_EMPTY,
) : EmaBaseState