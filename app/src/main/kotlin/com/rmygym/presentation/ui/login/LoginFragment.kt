package com.rmygym.presentation.ui.login

import com.rmygym.R
import com.rmygym.presentation.base.BaseFragment
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

    private fun setListeners(viewModel: LoginViewModel) {
        tvLoginRegister.setOnClickListener { viewModel.onActionRegisterClick() }
        btLoginDoLogin.setOnClickListener { viewModel.onActionLoginClick() }
    }

}