package com.rmygym.presentation.base

import com.rmygym.presentation.ui.main.MainViewModel
import com.rmygym.presentation.ui.main.MainViewState
import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState

abstract class BaseViewModel<T, NS : EmaNavigationState> : EmaViewModel<T, NS>() {

    lateinit var mainViewModel: MainViewModel

    abstract fun provideToolbar(): MainViewState.Toolbar

    override fun onResume(firstTime: Boolean) {
        mainViewModel.onToolbarChanged(provideToolbar())
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
        // Nothing to do
    }

    fun onError(error: Exception) {
        updateToErrorState(error)
    }
}
