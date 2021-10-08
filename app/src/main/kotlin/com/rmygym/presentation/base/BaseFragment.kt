package com.rmygym.presentation.base

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.rmygym.presentation.di.generateFragmentModule
import com.rmygym.presentation.ui.main.MainViewModel
import es.babel.easymvvm.android.ui.EmaFragment
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaBaseState
import es.babel.easymvvm.core.state.EmaExtraData
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

abstract class BaseFragment<S : EmaBaseState, VM : BaseViewModel<S, NS>, NS : EmaNavigationState> :
    EmaFragment<S, VM, NS>() {

    override val fragmentViewModelScope = true

    private val mainToolbarsViewModelSeed: MainViewModel by instance()

    private lateinit var mainViewModel: MainViewModel

    override fun injectFragmentModule(kodein: Kodein.MainBuilder) =
        generateFragmentModule(fragment = this)

    override fun onInitialized(viewModel: VM) {
        mainViewModel = addExtraViewModel(mainToolbarsViewModelSeed, this, requireActivity())
        (viewModel as BaseViewModel<*, *>).mainViewModel = mainViewModel
    }

    override fun onSingleEvent(data: EmaExtraData) {
        // Nothing to do
    }

    override fun onStateError(error: Throwable) {
        // Nothing to do
    }

    override fun onStateAlternative(data: EmaExtraData) {
        // Handle common dialogs like loading one
    }

    override fun onStateNormalFirstTime(data: S) {
        // Nothing to do
    }

    override fun onStateNormal(data: S) {
        // Handle common dialogs like loading one
    }

    override fun onNavigation(navigation: EmaNavigationState?) {
        super.onNavigation(navigation)
        view?.let { view -> hideKeyboard(view) }
    }

    private fun hideKeyboard(view: View) {
        (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(view.windowToken, NO_FLAGS)
    }

    companion object {
        const val NO_FLAGS = 0
    }
}
