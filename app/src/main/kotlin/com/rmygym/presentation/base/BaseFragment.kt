package com.rmygym.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import com.rmygym.R
import com.rmygym.presentation.di.generateFragmentModule
import com.rmygym.presentation.style.RmyGymTheme
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

    override val layoutId: Int = R.layout.layout_base

    private val mainToolbarsViewModelSeed: MainViewModel by instance()

    private lateinit var mainViewModel: MainViewModel

    override fun injectFragmentModule(kodein: Kodein.MainBuilder) =
        generateFragmentModule(fragment = this)

    override fun onInitialized(viewModel: VM) {
        mainViewModel = addExtraViewModel(mainToolbarsViewModelSeed, this, requireActivity())
        (viewModel as BaseViewModel<*, *>).mainViewModel = mainViewModel
    }

    override fun onSingleEvent(data: EmaExtraData) = Unit

    override fun onStateError(error: Throwable) {
        onError(error)
    }

    override fun onStateAlternative(data: EmaExtraData) {
        onAlternative(data)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(inflater.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    override fun onStateNormalFirstTime(data: S) = Unit

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
