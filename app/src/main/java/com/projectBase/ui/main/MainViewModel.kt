package com.projectBase.ui.main

import com.projectBase.base.BaseViewModel

class MainViewModel : BaseViewModel<MainState, MainNavigator.Navigation>() {

    override val initialViewState = MainState()

    override fun provideToolbar() = MainState.Toolbar()

    fun onActionBackClicked() {
        navigateBack()
    }

}