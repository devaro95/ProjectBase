package com.projectBase.ui.register

import com.domain.model.request.RequestRegisterModel
import com.domain.useCase.RegisterUseCase
import com.projectBase.base.BaseViewModel
import com.projectBase.ui.main.MainState

class RegisterViewModel(private val registerUseCase: RegisterUseCase) : BaseViewModel<RegisterState, RegisterNavigator.Navigation>() {

    override val initialViewState = RegisterState()

    override fun provideToolbar() = MainState.Toolbar(isVisible = false)

    fun onActionEmailChange(email: String) {
        updateDataState { copy(email = email) }
    }

    fun onActionUsernameChange(username: String) {
        updateDataState { copy(username = username) }
    }

    fun onActionPasswordChange(password: String) {
        updateDataState { copy(password = password) }
    }

    fun onActionHeightChange(height: String) {
        updateDataState { copy(height = height) }
    }

    fun onActionWeightChange(weight: String) {
        updateDataState { copy(weight = weight) }
    }

    fun onActionRegisterClick() {
        getDataState().apply {
            executeUseCaseWithException({
                registerUseCase.execute(
                    RequestRegisterModel(
                        email = email,
                        password = password,
                        name = name,
                        firstSurname = firstSurname,
                        secondSurname = secondSurname,
                        username = username,
                        age = age,
                        height = height,
                        weight = weight
                    )
                )
                onRegisterSuccess()
            }, { error -> updateToErrorState(error) })
        }
    }

    private fun onRegisterSuccess() {

    }
}