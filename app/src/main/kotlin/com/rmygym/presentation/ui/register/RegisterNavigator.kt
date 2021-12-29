package com.rmygym.presentation.ui.register

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class RegisterNavigator(override val navController: NavController) :
    EmaNavigator<RegisterNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState
}
