package com.rmygym.presentation.ui.register

import com.rmygym.presentation.base.BaseViewModel
import com.rmygym.presentation.ui.main.MainViewState

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

class RegisterViewModel : BaseViewModel<RegisterState, RegisterNavigator.Navigation>() {

    override val initialViewState = RegisterState()

    override fun provideToolbar() = MainViewState.Toolbar()

}