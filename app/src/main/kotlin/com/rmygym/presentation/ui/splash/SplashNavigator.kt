package com.rmygym.presentation.ui.splash

import androidx.navigation.NavController
import com.rmygym.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class SplashNavigator(override val navController: NavController) :
    EmaNavigator<SplashNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {

        object SplashToHome : SplashNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as SplashNavigator
                nav.splashToHome()
            }
        }
    }

    private fun splashToHome() {

    }
}
