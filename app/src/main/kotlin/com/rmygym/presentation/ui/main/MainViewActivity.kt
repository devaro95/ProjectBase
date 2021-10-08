package com.rmygym.presentation.ui.main

import android.os.Bundle
import android.view.View
import com.rmygym.R
import com.rmygym.presentation.base.BaseActivity
import com.rmygym.presentation.model.ActivityResultHandlerModel
import com.rmygym.presentation.ui.main.MainViewModel.Companion.RESULT_HANDLER_ADDED_TYPE
import com.rmygym.presentation.ui.main.MainViewModel.Companion.RESULT_HANDLER_REMOVED_TYPE
import es.babel.easymvvm.android.extra.EmaReceiverModel
import es.babel.easymvvm.android.extra.EmaResultModel
import es.babel.easymvvm.android.ui.EmaView
import es.babel.easymvvm.core.state.EmaExtraData
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.generic.instance

class MainViewActivity : BaseActivity(), EmaView<MainViewState, MainViewModel, MainNavigator.Navigation> {

    override val viewModelSeed: MainViewModel by instance()

    override val navigator: MainNavigator by instance()

    override val inputState: MainViewState? by instance()

    override var previousState: MainViewState? = null

    override val layoutId: Int = R.layout.activity_main

    override val navGraph: Int = R.navigation.navigation_main

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel(fragmentActivity = this)
    }

    override fun onViewModelInitialized(viewModel: MainViewModel) {
        this.viewModel = viewModel
    }

    override fun onResultReceiverInvokeEvent(emaReceiverModel: EmaReceiverModel) {
        // Nothing to do
    }

    override fun onResultSetEvent(emaResultModel: EmaResultModel) {
        // Nothing to do
    }

    override fun onSingleEvent(data: EmaExtraData) {
        when (data.type) {
            RESULT_HANDLER_ADDED_TYPE ->
                addActivityResultHandler(data.extraData as ActivityResultHandlerModel)
            RESULT_HANDLER_REMOVED_TYPE ->
                removeActivityResultHandler(data.extraData as Int)
            else -> Unit
        }
    }

    override fun onStateAlternative(data: EmaExtraData) {
        // Nothing to do
    }

    override fun onStateError(error: Throwable) {
        // Nothing to do
    }

    override fun onStateNormalFirstTime(data: MainViewState) {
        // Nothing to do
    }

    override fun onStateNormal(data: MainViewState) {
        setupToolbar(data)
    }

    override fun onBackPressed() {
        viewModel.onActionBackPressed()
    }

    private fun setupToolbar(data: MainViewState) {
        toolbar.visibility = if (data.toolbar.isVisible) View.VISIBLE else View.GONE
    }
}
