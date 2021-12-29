package com.rmygym.presentation.ui.splash

import com.rmygym.presentation.base.BaseViewModel
import com.rmygym.presentation.ui.main.MainViewState
import kotlinx.coroutines.delay

class SplashViewModel : BaseViewModel<SplashViewState, SplashNavigator.Navigation>() {

    override val initialViewState: SplashViewState = SplashViewState()

    override fun provideToolbar() = MainViewState.Toolbar()

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
        const val SPLASH_DELAY = 2000L
    }
}
