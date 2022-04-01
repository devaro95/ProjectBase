package com.projectBase.ui.register

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import com.carmabs.ema.android.viewmodel.EmaAndroidViewModel
import com.carmabs.ema.core.state.EmaExtraData
import com.projectBase.base.BaseFragment
import org.kodein.di.generic.instance

class RegisterFragment : BaseFragment<RegisterState, RegisterViewModel, RegisterNavigator.Navigation>() {

    override val navigator: RegisterNavigator by instance()

    override val viewModelSeed: RegisterViewModel by instance()

    override val androidViewModelSeed: EmaAndroidViewModel<RegisterViewModel> by instance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
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