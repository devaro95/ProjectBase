package com.projectBase.ui.splash

import com.carmabs.ema.android.viewmodel.EmaAndroidViewModel
import com.carmabs.ema.core.state.EmaExtraData
import com.projectBase.R
import com.projectBase.base.BaseFragment
import com.projectBase.inject.generateFragmentModule
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class SplashViewFragment : BaseFragment<SplashViewState, SplashViewModel, SplashNavigator.Navigation>() {

    override val androidViewModelSeed: EmaAndroidViewModel<SplashViewModel> by instance<SplashAndroidViewModel>()

    override val layoutId: Int = R.layout.fragment_splash

    override val navigator: SplashNavigator by instance()

    override val viewModelSeed: SplashViewModel by instance()

    override fun injectFragmentModule(kodein: Kodein.MainBuilder): Kodein.Module = generateFragmentModule(fragment = this)

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

    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onNormal(data: SplashViewState) {

    }

    override fun onError(error: Throwable) {

    }
}
