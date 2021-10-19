package com.rmygym.presentation.ui.login

import com.rmygym.domain.exceptions.Login
import com.rmygym.domain.exceptions.Login.InvalidCredentialsException
import com.rmygym.domain.model.UserModel
import com.rmygym.domain.model.request.RequestLoginModel
import com.rmygym.domain.usecase.LoginUseCase
import com.rmygym.presentation.base.BaseViewModel
import com.rmygym.presentation.ui.main.MainViewState

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

class LoginViewModel(private val loginUseCase: LoginUseCase) : BaseViewModel<LoginState, LoginNavigator.Navigation>() {

    override val initialViewState = LoginState()

    override fun provideToolbar() = MainViewState.Toolbar()

    fun onActionRegisterClick() {
        navigate(LoginNavigator.Navigation.FromLoginToRegister)
    }

    fun onActionLoginClick() {
        checkDataState {
            if (it.fieldsAreValid()) updateToErrorState(InvalidCredentialsException())
            else it.executeLoginUseCase()
        }
    }

    private fun LoginState.executeLoginUseCase() {
        executeUseCaseWithException({
            loginUseCase.execute(
                RequestLoginModel(
                    email = email,
                    password = password,
                    onSuccess = { data -> onLoginSuccess(data as UserModel) },
                    onError = { onLoginError(it) }
                )
            )
        }, { error -> updateToErrorState(error) })
    }

    private fun onLoginSuccess(data: UserModel) {
        navigate(LoginNavigator.Navigation.FromLoginToHome)
    }

    private fun onLoginError(error: Exception) {
        updateToErrorState(error)
    }

    fun onActionEmailChange(email: String) {
        checkDataState {
            if (email != it.email) updateToNormalState { copy(email = email) }
        }
    }

    fun onActionPasswordChange(password: String) {
        checkDataState {
            if (password != it.password) updateToNormalState { copy(password = password) }
        }
    }

    private fun LoginState.fieldsAreValid() = email.isEmpty() || password.isEmpty() || password.length < MIN_PASSWORD_LENGTH

    companion object {
        const val MIN_PASSWORD_LENGTH = 6
    }
}