package com.projectBase.ui.register

import android.app.Activity
import androidx.navigation.NavController
import com.carmabs.ema.android.navigation.EmaAndroidNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState

class RegisterNavigator(override val navController: NavController, override val activity: Activity) : EmaAndroidNavigator<RegisterNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState
}
