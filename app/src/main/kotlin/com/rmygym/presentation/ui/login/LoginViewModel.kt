package com.rmygym.presentation.ui.login

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
        executeUseCaseWithException({
            loginUseCase.execute(
                RequestLoginModel(
                    onSuccess = { data -> onLoginSuccess(data as UserModel) },
                    onError = { onError(it) }
                )
            )
        }, { error -> updateToErrorState(error) })

    }

    private fun onLoginSuccess(data: UserModel) {
        navigate(LoginNavigator.Navigation.FromLoginToHome)
    }

}