package com.rmygym.presentation.ui.home

import androidx.compose.runtime.Composable
import androidx.recyclerview.widget.LinearLayoutManager
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
        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    @Composable
    override fun OnNormal(data: HomeState) {
        HomeScreen(homeState = data)
    }

    override fun onError(error: Throwable) = Unit

    override fun onAlternative(data: EmaExtraData) = Unit
}
