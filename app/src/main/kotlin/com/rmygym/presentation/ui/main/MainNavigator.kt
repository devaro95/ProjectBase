package com.rmygym.presentation.ui.main

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class MainNavigator(override val navController: NavController) :
    EmaNavigator<MainNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {
        object ToBack : MainNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                // Nothing to do
            }
        }
    }
}
