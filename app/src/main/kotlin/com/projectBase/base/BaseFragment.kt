package com.projectBase.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import com.carmabs.ema.android.ui.EmaFragment
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.state.EmaBaseState
import com.carmabs.ema.core.state.EmaExtraData
import com.projectBase.R
import com.projectBase.inject.generateFragmentModule
import com.projectBase.style.RmyGymTheme
import org.kodein.di.Kodein

abstract class BaseFragment<S : EmaBaseState, VM : BaseViewModel<S, NS>, NS : EmaNavigationState> : EmaFragment<S, VM, NS>() {

    override val fragmentViewModelScope = true

    override val layoutId: Int = R.layout.layout_base

    override fun injectFragmentModule(kodein: Kodein.MainBuilder) = generateFragmentModule(fragment = this)

    override fun onSingleEvent(data: EmaExtraData) = Unit

    override fun onStateError(error: Throwable) {
        onError(error)
    }

    override fun onStateAlternative(data: EmaExtraData) {
        onAlternative(data)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(inflater.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    override fun onStateNormal(data: S) {
        (view as ComposeView).apply {
            setContent {
                RmyGymTheme {
                    OnNormal(data)
                }
            }
        }
    }

    @Composable
    abstract fun OnNormal(data: S)

    override fun onNavigation(navigation: EmaNavigationState?) {
        super.onNavigation(navigation)
        view?.let { view -> hideKeyboard(view) }
    }

    abstract fun onError(error: Throwable)

    abstract fun onAlternative(data: EmaExtraData)

    private fun hideKeyboard(view: View) {
        (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(view.windowToken, NO_FLAGS)
    }

    companion object {
        const val NO_FLAGS = 0
    }
}
