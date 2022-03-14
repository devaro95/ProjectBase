package com.projectBase.ui.home

import com.projectBase.base.BaseViewModel
import com.projectBase.ui.main.MainNavigator
import com.projectBase.ui.main.MainState

class HomeViewModel : BaseViewModel<HomeState, MainNavigator.Navigation>() {

    override val initialViewState= HomeState()

    override fun provideToolbar(): MainState.Toolbar = MainState.Toolbar(isVisible = true)

}
