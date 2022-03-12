package com.projectBase.ui.home

import com.carmabs.ema.android.viewmodel.EmaAndroidViewModel
import com.projectBase.base.BaseViewModel
import com.projectBase.ui.main.MainNavigator
import com.projectBase.ui.main.MainState
import org.kodein.di.generic.instance

class HomeViewModel : BaseViewModel<HomeViewState, MainNavigator.Navigation>() {

    override val initialViewState= HomeViewState()

    override fun provideToolbar(): MainState.Toolbar = MainState.Toolbar(isVisible = true)

}
