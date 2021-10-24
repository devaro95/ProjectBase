package com.rmygym.presentation.ui.home

import com.rmygym.R
import com.rmygym.presentation.base.BaseFragment
import com.rmygym.presentation.ui.main.MainNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import org.kodein.di.generic.instance

class HomeFragment : BaseFragment<HomeState, HomeViewModel, MainNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_home

    override val navigator: MainNavigator by instance()

    override val viewModelSeed: HomeViewModel by instance()

    private lateinit var viewModel: HomeViewModel

    override fun onInitialized(viewModel: HomeViewModel) {
        super.onInitialized(viewModel)
        this.viewModel = viewModel
    }

    override fun onError(error: Throwable) = Unit

    override fun onNormal(data: HomeState) = Unit

    override fun onAlternative(data: EmaExtraData) = Unit
}