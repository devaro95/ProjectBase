package com.rmygym.presentation.ui.selector

import com.rmygym.R
import com.rmygym.presentation.base.BaseFragment
import com.rmygym.presentation.ui.main.MainNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import kotlinx.android.synthetic.main.fragment_selector_exercise.*
import org.kodein.di.generic.instance

class SelectorExerciseFragment : BaseFragment<SelectorExerciseState, SelectorExerciseViewModel, MainNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_selector_exercise

    override val navigator: MainNavigator by instance()

    override val viewModelSeed: SelectorExerciseViewModel by instance()

    private lateinit var viewModel: SelectorExerciseViewModel

    override fun onInitialized(viewModel: SelectorExerciseViewModel) {
        super.onInitialized(viewModel)
        this.viewModel = viewModel
    }

    private fun setItemGroups(){
        csevSelectorChestGroup.setListItems(mutableListOf())
        csevSelectorBackGroup.setListItems(mutableListOf())
    }

    override fun onError(error: Throwable) = Unit

    override fun onNormal(data: SelectorExerciseState) = Unit

    override fun onAlternative(data: EmaExtraData) = Unit
}
