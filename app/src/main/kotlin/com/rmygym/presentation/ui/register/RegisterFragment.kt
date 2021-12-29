package com.rmygym.presentation.ui.register

import androidx.compose.runtime.Composable
import com.rmygym.presentation.base.BaseFragment
import es.babel.easymvvm.core.state.EmaExtraData
import org.kodein.di.generic.instance

class RegisterFragment :
    BaseFragment<RegisterState, RegisterViewModel, RegisterNavigator.Navigation>() {

    override val navigator: RegisterNavigator by instance()

    override val viewModelSeed: RegisterViewModel by instance()

    private lateinit var vm: RegisterViewModel

    override fun onInitialized(viewModel: RegisterViewModel) {
        super.onInitialized(viewModel)
        this.vm = viewModel
    }

    override fun onError(error: Throwable) = Unit

    @Composable
    override fun OnNormal(data: RegisterState) {
        RegisterScreen(data, setListeners())
    }

    override fun onAlternative(data: EmaExtraData) = Unit

    private fun setListeners(): RegisterListeners {
        return object : RegisterListeners {
            override fun onUsernameChange(username: String) = vm.onActionUsernameChange(username)
            override fun onEmailChange(email: String) = vm.onActionEmailChange(email)
            override fun onPasswordChange(password: String) = vm.onActionPasswordChange(password)
            override fun onWeightChange(weight: String) = vm.onActionWeightChange(weight)
            override fun onHeightChange(height: String) = vm.onActionHeightChange(height)
            override fun onRegister() = vm.onActionRegisterClick()
        }
    }
}