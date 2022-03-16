package com.projectBase.ui.login

import com.domain.model.request.RequestLoginModel
import com.domain.useCase.LoginUseCase
import com.projectBase.base.BaseViewModel
import com.projectBase.ui.main.MainState

class LoginViewModel(private val loginUseCase: LoginUseCase) : BaseViewModel<LoginState, LoginNavigator.Navigation>() {

    override val initialViewState = LoginState()

    override fun provideToolbar() = MainState.Toolbar(isVisible = false)

    fun onActionEmailChange(email: String) {
        getDataState().also {
            if (email != it.email) updateToNormalState { copy(email = email) }
        }
    }

    fun onActionPasswordChange(password: String) {
        getDataState().also {
            if (password != it.password) updateToNormalState { copy(password = password) }
        }
    }

    fun onActionLoginClick() {
        getDataState().apply {
            if (fieldsAreValid()) updateToErrorState(Exception())
            else executeLoginUseCase()
        }
    }

    private fun LoginState.executeLoginUseCase() {
        executeUseCaseWithException({
            loginUseCase.execute(
                RequestLoginModel(
                    email = email,
                    password = password
                )
            )
            navigate(LoginNavigator.Navigation.FromLoginToHome)
        }, { error -> updateToErrorState(error) })
    }

    fun onActionRegisterClick() {
        navigate(LoginNavigator.Navigation.FromLoginToRegister)
    }

    private fun LoginState.fieldsAreValid() = email.isEmpty() || password.isEmpty() || password.length < MIN_PASSWORD_LENGTH

    companion object {
        const val MIN_PASSWORD_LENGTH = 6
    }
}