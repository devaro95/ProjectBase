package com.projectBase.ui.splash

import com.projectBase.base.BaseViewModel
import com.projectBase.ui.main.MainState
import kotlinx.coroutines.delay

class SplashViewModel : BaseViewModel<SplashState, SplashNavigator.Navigation>() {

    override fun provideToolbar() = MainState.Toolbar(isVisible = false)

    override val initialViewState: SplashState = SplashState()

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
