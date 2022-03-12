package com.projectBase.base

import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.viewmodel.EmaViewModel
import com.projectBase.ui.main.MainState

abstract class BaseViewModel<T : Any, NS : EmaNavigationState> : EmaViewModel<T, NS>() {

    abstract fun provideToolbar(): MainState.Toolbar

    override fun onResume(firstTime: Boolean) {
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
    }
}