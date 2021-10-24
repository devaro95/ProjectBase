package com.rmygym.presentation.ui.selector

import com.rmygym.presentation.base.BaseViewModel
import com.rmygym.presentation.ui.main.MainNavigator
import com.rmygym.presentation.ui.main.MainViewState

class SelectorExerciseViewModel : BaseViewModel<SelectorExerciseState, MainNavigator.Navigation>() {

    override val initialViewState: SelectorExerciseState = SelectorExerciseState()

    override fun provideToolbar(): MainViewState.Toolbar = MainViewState.Toolbar(isVisible = true)
}
