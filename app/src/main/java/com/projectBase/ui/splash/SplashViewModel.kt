package com.projectBase.ui.splash

import com.projectBase.base.BaseViewModel
import com.projectBase.ui.main.MainState
import kotlinx.coroutines.delay

class SplashViewModel : BaseViewModel<SplashViewState, SplashNavigator.Navigation>() {

    override fun provideToolbar() = MainState.Toolbar()

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
