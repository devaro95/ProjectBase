package com.projectBase.ui.login

import android.app.Activity
import androidx.navigation.NavController
import com.carmabs.ema.android.navigation.EmaAndroidNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.navigator.EmaNavigator
import com.projectBase.R

class LoginNavigator(override val activity: Activity, override val navController: NavController) : EmaAndroidNavigator<LoginNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {
        object FromLoginToRegister : Navigation() {
            override fun navigateWith(navigator: EmaNavigator<out EmaNavigationState>) {
                (navigator as LoginNavigator).fromLoginToRegister()
            }
        }

        object FromLoginToHome : Navigation() {
            override fun navigateWith(navigator: EmaNavigator<out EmaNavigationState>) {
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
