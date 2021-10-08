package com.rmygym.presentation.ui.splash

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import kotlinx.coroutines.delay

class SplashViewModel : EmaViewModel<SplashViewState, SplashNavigator.Navigation>() {

    override val initialViewState: SplashViewState = SplashViewState()

    override fun onResume(firstTime: Boolean) {
        // Nothing to do
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
        executeUseCase {
            delay(SPLASH_DELAY)
            navigate(SplashNavigator.Navigation.SplashToHome)
        }
    }

    private companion object {
        const val SPLASH_DELAY = 3000L
    }
}
