package com.rmygym.presentation.ui.register

import com.rmygym.domain.model.UserModel
import com.rmygym.domain.model.request.RequestRegisterModel
import com.rmygym.domain.usecase.RegisterUseCase
import com.rmygym.presentation.base.BaseViewModel
import com.rmygym.presentation.ui.main.MainViewState

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : BaseViewModel<RegisterState, RegisterNavigator.Navigation>() {

    override val initialViewState = RegisterState()

    override fun provideToolbar() = MainViewState.Toolbar()

    fun onActionEmailChange(email: String) {
        checkDataState {
            updateDataState { copy(email = email) }
        }
    }

    fun onActionUsernameChange(username: String) {
        checkDataState {
            updateDataState { copy(username = username) }
        }
    }

    fun onActionPasswordChange(password: String) {
        checkDataState {
            updateDataState { copy(password = password) }
        }
    }

    fun onActionHeightChange(height: String) {
        checkDataState {
            updateDataState { copy(height = height) }
        }
    }

    fun onActionWeightChange(weight: String) {
        checkDataState {
            updateDataState { copy(weight = weight) }
        }
    }

    fun onActionRegisterClick() {
        checkDataState {
            executeUseCaseWithException({
                registerUseCase.execute(
                    RequestRegisterModel(
                        email = it.email,
                        password = it.password,
                        name = it.name,
                        firstSurname = it.firstSurname,
                        secondSurname = it.secondSurname,
                        username = it.username,
                        age = it.age,
                        height = it.height,
                        weight = it.weight,
                        onSuccess = { onRegisterSuccess(it as UserModel) },
                        onError = { onRegisterError(it) }
                    )
                )
            }, { error -> updateToErrorState(error) })
        }
    }

    private fun onRegisterSuccess(user: UserModel) {

    }

    private fun onRegisterError(error: Exception) {
        updateToErrorState(error)
    }

}