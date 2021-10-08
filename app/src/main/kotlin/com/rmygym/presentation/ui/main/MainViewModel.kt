package com.rmygym.presentation.ui.main

import es.babel.easymvvm.android.viewmodel.EmaViewModel

class MainViewModel : EmaViewModel<MainViewState, MainNavigator.Navigation>() {

    override val initialViewState: MainViewState = MainViewState()

    override fun onStartFirstTime(statePreloaded: Boolean) {
        // Nothing to do
    }

    override fun onResume(firstTime: Boolean) {
        // Nothing to do
    }

    fun onToolbarChanged(toolbar: MainViewState.Toolbar) {
        updateToNormalState { copy(toolbar = toolbar) }
    }

    fun onActionBackPressed() {
        navigate(MainNavigator.Navigation.ToBack)
    }

    companion object {
        const val RESULT_HANDLER_ADDED_TYPE = 1
        const val RESULT_HANDLER_REMOVED_TYPE = 2
    }
}
