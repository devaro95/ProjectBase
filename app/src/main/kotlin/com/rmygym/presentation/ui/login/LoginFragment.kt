package com.rmygym.presentation.ui.login

import android.view.View
import androidx.core.widget.addTextChangedListener
import com.rmygym.R
import com.rmygym.domain.exceptions.Login.InvalidCredentialsException
import com.rmygym.presentation.base.BaseFragment
import es.babel.easymvvm.core.state.EmaExtraData
import kotlinx.android.synthetic.main.fragment_login.*
import org.kodein.di.generic.instance

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

class LoginFragment : BaseFragment<LoginState, LoginViewModel, LoginNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_login

    override val navigator: LoginNavigator by instance()

    override val viewModelSeed: LoginViewModel by instance()

    override fun onInitialized(viewModel: LoginViewModel) {
        super.onInitialized(viewModel)
        setListeners(viewModel)
    }

    override fun onError(error: Throwable) {
        when (error) {
            is InvalidCredentialsException -> tvLoginError.visibility = View.VISIBLE
        }
    }

    override fun onNormal(data: LoginState) {
        tvLoginError.visibility = View.GONE
    }

    override fun onAlternative(data: EmaExtraData) = Unit

    private fun setListeners(viewModel: LoginViewModel) {
        etLoginUsername.addTextChangedListener { viewModel.onActionEmailChange(it.toString()) }
        etLoginPassword.addTextChangedListener { viewModel.onActionPasswordChange(it.toString()) }
        tvLoginRegister.setOnClickListener { viewModel.onActionRegisterClick() }
        btLoginDoLogin.setOnClickListener { viewModel.onActionLoginClick() }
    }

}