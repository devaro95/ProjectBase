package com.projectBase.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import com.carmabs.ema.core.state.EmaExtraData
import com.carmabs.ema.core.view.EmaView
import com.carmabs.ema.core.view.EmaViewModelTrigger
import com.projectBase.R
import com.projectBase.base.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import org.kodein.di.generic.instance

class MainActivity : BaseActivity(), EmaView<MainState, MainViewModel, MainNavigator.Navigation> {

    override val layoutId = R.layout.activity_main

    override var previousState: MainState? = null

    override val navGraph: Int = R.navigation.navigation_main

    override val viewModelSeed: MainViewModel by instance()

    override val navigator: MainNavigator by instance()

    override val inputState: MainState? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        //setupToolbar(viewModel)
    }

    private fun setupToolbar(viewModel: MainViewModel) {
        navController.addOnDestinationChangedListener { _, _, _ ->

        }
    }

    override fun onBackPressed() = Unit

    override fun onStateNormal(data: MainState) = Unit

    override fun onStateAlternative(data: EmaExtraData) = Unit

    override fun onSingleEvent(data: EmaExtraData) = Unit

    override fun onStateError(error: Throwable) = Unit

    private fun onBackSystemPressed() {
       // viewModel.onActionBackClicked()
    }

    override val coroutineScope: CoroutineScope = CoroutineScope(IO)
    override var isFirstErrorExecution: Boolean = true
    override var isFirstNormalExecution: Boolean = true
    override var isFirstAlternativeExecution: Boolean = true
    override val startTrigger: EmaViewModelTrigger? = null
    override val updatePreviousStateAutomatically: Boolean = true
}