package com.rmygym.presentation.ui.login

import androidx.navigation.NavController
import com.rmygym.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

/**
 * <p>
 * Copyright (c) 2021, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 */

class LoginNavigator(override val navController: NavController) :
    EmaNavigator<LoginNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {
        object FromLoginToRegister : LoginNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                (navigator as LoginNavigator).fromLoginToRegister()
            }
        }

        object FromLoginToHome : LoginNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                (navigator as LoginNavigator).fromLoginToHome()
            }
        }
    }

    private fun fromLoginToRegister() {
        navigateWithAction(R.id.action_loginFragment_to_registerFragment)
    }

    private fun fromLoginToHome() {
        navigateWithAction(R.id.action_loginFragment_to_homeFragment)
    }
}
