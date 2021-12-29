package com.rmygym.presentation.ui.home

import androidx.compose.runtime.Composable
import com.rmygym.presentation.base.BaseFragment
import com.rmygym.presentation.ui.main.MainNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import org.kodein.di.generic.instance

class HomeFragment : BaseFragment<HomeState, HomeViewModel, MainNavigator.Navigation>() {

    override val navigator: MainNavigator by instance()

    override val viewModelSeed: HomeViewModel by instance()

    private lateinit var viewModel: HomeViewModel

    override fun onInitialized(viewModel: HomeViewModel) {
        super.onInitialized(viewModel)
        this.viewModel = viewModel
    }

    override fun onError(error: Throwable) = Unit

    override fun onAlternative(data: EmaExtraData) = Unit

    @Composable
    override fun OnNormal(data: HomeState) {
    }
}
