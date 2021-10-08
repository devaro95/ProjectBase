package com.rmygym.presentation.ui.home

import com.rmygym.presentation.base.BaseViewModel
import com.rmygym.presentation.ui.main.MainNavigator
import com.rmygym.presentation.ui.main.MainViewState

class HomeViewModel : BaseViewModel<HomeViewState, MainNavigator.Navigation>() {

    override val initialViewState: HomeViewState = HomeViewState()

    override fun provideToolbar(): MainViewState.Toolbar = MainViewState.Toolbar(isVisible = true)

}
