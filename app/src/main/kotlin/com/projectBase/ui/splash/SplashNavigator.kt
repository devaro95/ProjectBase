package com.projectBase.ui.splash

import android.app.Activity
import androidx.navigation.NavController
import com.carmabs.ema.android.navigation.EmaAndroidNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.navigator.EmaNavigator
import com.projectBase.R

class SplashNavigator(override val navController: NavController, override val activity: Activity) : EmaAndroidNavigator<SplashNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {

        object SplashToHome : Navigation() {
            override fun navigateWith(navigator: EmaNavigator<out EmaNavigationState>) {
                val nav = navigator as SplashNavigator
                nav.splashToHome()
            }
        }
    }

    private fun splashToHome() {
        navigateWithAction(R.id.action_splashViewFragment2_to_loginFragment)
    }
}
