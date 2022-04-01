package com.projectBase.ui.splash

import androidx.compose.runtime.Composable
import com.carmabs.ema.android.viewmodel.EmaAndroidViewModel
import com.carmabs.ema.core.state.EmaExtraData
import com.projectBase.R
import com.projectBase.base.BaseFragment
import org.kodein.di.generic.instance

class SplashViewFragment : BaseFragment<SplashState, SplashViewModel, SplashNavigator.Navigation>() {

    override val androidViewModelSeed: EmaAndroidViewModel<SplashViewModel> by instance<SplashAndroidViewModel>()

    override val layoutId: Int = R.layout.fragment_splash

    override val navigator: SplashNavigator by instance()

    override val viewModelSeed: SplashViewModel by instance()

    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onError(error: Throwable) {

    }

    @Composable
    override fun OnNormal(data: SplashState) {
        SplashScreen()
    }
}
