package com.projectBase.base

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.carmabs.ema.android.ui.EmaFragment
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.state.EmaBaseState
import com.carmabs.ema.core.state.EmaExtraData
import com.projectBase.inject.generateFragmentModule
import org.kodein.di.Kodein

abstract class BaseFragment<S : EmaBaseState, VM : BaseViewModel<S, NS>, NS : EmaNavigationState> : EmaFragment<S, VM, NS>() {

    override val fragmentViewModelScope = true

    override fun injectFragmentModule(kodein: Kodein.MainBuilder): Kodein.Module = generateFragmentModule(this)

    override fun onStateError(error: Throwable) {
        onError(error)
    }

    override fun onStateAlternative(data: EmaExtraData) {
        onAlternative(data)
    }

    override fun onStateNormal(data: S) {
        onNormal(data)
    }

    abstract fun onAlternative(data: EmaExtraData)

    abstract fun onNormal(data: S)

    abstract fun onError(error: Throwable)

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

