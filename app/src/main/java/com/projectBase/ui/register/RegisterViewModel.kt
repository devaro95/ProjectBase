package com.projectBase.ui.register

import com.domain.model.request.RequestRegisterModel
import com.domain.useCase.RegisterUseCase
import com.projectBase.base.BaseViewModel
import com.projectBase.ui.main.MainState

class RegisterViewModel(private val registerUseCase: RegisterUseCase) : BaseViewModel<RegisterState, RegisterNavigator.Navigation>() {

    override val initialViewState = RegisterState()

    override fun provideToolbar() = MainState.Toolbar(isVisible = false)

    fun onActionEmailChange(email: String) {
        getDataState().apply {
            if (this.email != email) {
                updateToNormalState { copy(email = email) }
            }
        }
    }

    fun onActionUsernameChange(username: String) {
        getDataState().apply {
            if (this.username != username) {
                updateToNormalState { copy(username = username) }
            }
        }
    }

    fun onActionPasswordChange(password: String) {
        getDataState().apply {
            if (this.password != password) {
                updateToNormalState { copy(password = password) }
            }
        }
    }

    fun onActionHeightChange(height: String) {
        getDataState().apply {
            if (this.height != height) {
                updateToNormalState { copy(height = height) }
            }
        }
    }

    fun onActionWeightChange(weight: String) {
        getDataState().apply {
            if (this.weight != weight) {
                updateToNormalState { copy(weight = weight) }
            }
        }
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