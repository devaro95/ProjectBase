package com.rmygym.presentation.ui.register

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

class RegisterNavigator(override val navController: NavController) :
    EmaNavigator<RegisterNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState
}
