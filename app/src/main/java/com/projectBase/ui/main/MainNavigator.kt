package com.projectBase.ui.main

import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.navigator.EmaNavigator

class MainNavigator : EmaNavigator<MainNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState

    override fun navigateBack(): Boolean = true
}
