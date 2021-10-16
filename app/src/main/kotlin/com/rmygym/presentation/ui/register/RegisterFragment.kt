package com.rmygym.presentation.ui.register

import com.rmygym.R
import com.rmygym.presentation.base.BaseFragment
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

}