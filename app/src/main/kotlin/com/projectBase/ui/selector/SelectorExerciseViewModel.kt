package com.projectBase.ui.selector

import com.projectBase.base.BaseViewModel
import com.projectBase.ui.main.MainNavigator
import com.projectBase.ui.main.MainState

class SelectorExerciseViewModel : BaseViewModel<SelectorExerciseState, MainNavigator.Navigation>() {

    override val initialViewState: SelectorExerciseState = SelectorExerciseState()

    override fun provideToolbar(): MainState.Toolbar = MainState.Toolbar(isVisible = true)
}
