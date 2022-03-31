package com.projectBase.ui.login

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import com.carmabs.ema.android.viewmodel.EmaAndroidViewModel
import com.carmabs.ema.core.state.EmaExtraData
import com.projectBase.base.BaseFragment
import org.kodein.di.generic.instance

class LoginFragment : BaseFragment<LoginState, LoginViewModel, LoginNavigator.Navigation>() {

    override val navigator: LoginNavigator by instance()

    override val viewModelSeed: LoginViewModel by instance()

    override val androidViewModelSeed: EmaAndroidViewModel<LoginViewModel> by instance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    override fun onError(error: Throwable) {
        when (error) {
            //  is InvalidCredentialsException -> tvLoginError.visibility = View.VISIBLE
        }
    }

    @Composable
    override fun OnNormal(data: LoginState) {
        LoginScreen(data, setListeners())
    }

    override fun onAlternative(data: EmaExtraData) = Unit

    private fun setListeners(): LoginListeners {
        return object : LoginListeners {
            override fun onEmailChange(email: String) = vm.onActionEmailChange(email)
            override fun onLogin() = vm.onActionLoginClick()
            override fun onPasswordChange(password: String) = vm.onActionPasswordChange(password)
            override fun onRegister() = vm.onActionRegisterClick()
        }
    }
}