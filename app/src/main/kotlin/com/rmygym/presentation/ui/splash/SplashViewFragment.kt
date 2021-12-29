package com.rmygym.presentation.ui.splash

import androidx.compose.runtime.Composable
import com.rmygym.R
import com.rmygym.presentation.base.BaseFragment
import es.babel.easymvvm.core.state.EmaExtraData
import org.kodein.di.generic.instance

class SplashViewFragment :
    BaseFragment<SplashViewState, SplashViewModel, SplashNavigator.Navigation>() {

    override val fragmentViewModelScope: Boolean = true

    override val layoutId: Int = R.layout.fragment_splash

    override val navigator: SplashNavigator by instance()

    override val viewModelSeed: SplashViewModel by instance()

    override fun onInitialized(viewModel: SplashViewModel) {
    }

    @Composable
    override fun OnNormal(data: SplashViewState) {
        SplashScreen()
    }

    override fun onError(error: Throwable) {
    }

    override fun onAlternative(data: EmaExtraData) {
    }
}
