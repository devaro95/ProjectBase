package com.rmygym.presentation.ui.register

import androidx.core.widget.addTextChangedListener
import com.rmygym.R
import com.rmygym.presentation.base.BaseFragment
import es.babel.easymvvm.core.state.EmaExtraData
import kotlinx.android.synthetic.main.fragment_register.*
import org.kodein.di.generic.instance

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

class RegisterFragment : BaseFragment<RegisterState, RegisterViewModel, RegisterNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_register

    override val navigator: RegisterNavigator by instance()

    override val viewModelSeed: RegisterViewModel by instance()

    override fun onInitialized(viewModel: RegisterViewModel) {
        super.onInitialized(viewModel)
        setListeners(viewModel)
    }

    override fun onError(error: Throwable) = Unit

    override fun onNormal(data: RegisterState) = Unit

    override fun onAlternative(data: EmaExtraData) = Unit

    private fun setListeners(viewModel: RegisterViewModel) {
        btRegister.setOnClickListener { viewModel.onActionRegisterClick() }
        etRegisterEmail.addTextChangedListener { viewModel.onActionEmailChange(it.toString()) }
        etRegisterUsername.addTextChangedListener { viewModel.onActionUsernameChange(it.toString()) }
        etRegisterPassword.addTextChangedListener { viewModel.onActionPasswordChange(it.toString()) }
        etRegisterHeight.addTextChangedListener { viewModel.onActionHeightChange(it.toString()) }
        etRegisterWeight.addTextChangedListener { viewModel.onActionWeightChange(it.toString()) }
    }
}