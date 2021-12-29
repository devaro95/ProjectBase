package com.rmygym.presentation.ui.login

import androidx.compose.runtime.Composable
import com.rmygym.presentation.base.BaseFragment
import es.babel.easymvvm.core.state.EmaExtraData
import org.kodein.di.generic.instance

class LoginFragment : BaseFragment<LoginState, LoginViewModel, LoginNavigator.Navigation>() {

    override val navigator: LoginNavigator by instance()

    override val viewModelSeed: LoginViewModel by instance()

    private lateinit var vm: LoginViewModel

    override fun onInitialized(viewModel: LoginViewModel) {
        super.onInitialized(viewModel)
        this.vm = viewModel
    }

    @Composable
    override fun OnNormal(data: LoginState) {
        LoginScreen(data, setListeners())
    }

    override fun onError(error: Throwable) {

    }

    override fun onAlternative(data: EmaExtraData) {
    }

    private fun setListeners(): LoginListeners {
        return object : LoginListeners {
            override fun onEmailChange(email: String) = vm.onActionEmailChange(email)
            override fun onLogin() = vm.onActionLoginClick()
            override fun onPasswordChange(password: String) = vm.onActionPasswordChange(password)
            override fun onRegister() = vm.onActionRegisterClick()
        }
    }
}