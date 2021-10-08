package com.rmygym.presentation.ui.splash

import com.rmygym.R
import com.rmygym.presentation.di.generateFragmentModule
import es.babel.easymvvm.android.ui.EmaFragment
import es.babel.easymvvm.core.state.EmaExtraData
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class SplashViewFragment :
    EmaFragment<SplashViewState, SplashViewModel, SplashNavigator.Navigation>() {

    override val fragmentViewModelScope: Boolean = true

    override val layoutId: Int = R.layout.fragment_splash

    override val navigator: SplashNavigator by instance()

    override val viewModelSeed: SplashViewModel by instance()

    override fun injectFragmentModule(kodein: Kodein.MainBuilder): Kodein.Module =
        generateFragmentModule(fragment = this)

    override fun onInitialized(viewModel: SplashViewModel) {
        // Nothing to do
    }

    override fun onSingleEvent(data: EmaExtraData) {
        // Nothing to do
    }

    override fun onStateAlternative(data: EmaExtraData) {
        // Nothing to do
    }

    override fun onStateError(error: Throwable) {
        // Nothing to do
    }

    override fun onStateNormal(data: SplashViewState) {
        // Nothing to do
    }

    override fun onStateNormalFirstTime(data: SplashViewState) {
        // Nothing to do
    }
}
