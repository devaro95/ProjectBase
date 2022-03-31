package com.projectBase.ui.selector

import androidx.compose.runtime.Composable
import com.carmabs.ema.android.viewmodel.EmaAndroidViewModel
import com.carmabs.ema.core.state.EmaExtraData
import com.projectBase.base.BaseFragment
import com.projectBase.ui.main.MainNavigator
import org.kodein.di.generic.instance

class SelectorExerciseFragment : BaseFragment<SelectorExerciseState, SelectorExerciseViewModel, MainNavigator.Navigation>() {


    override val navigator: MainNavigator by instance()

    override val androidViewModelSeed: EmaAndroidViewModel<SelectorExerciseViewModel> by instance()

    override val viewModelSeed: SelectorExerciseViewModel by instance()

    override fun onError(error: Throwable) = Unit

    override fun onAlternative(data: EmaExtraData) = Unit

    @Composable
    override fun OnNormal(data: SelectorExerciseState) {

    }

    private fun setItemGroups(){
       // csevSelectorChestGroup.setListItems(mutableListOf())
       // csevSelectorBackGroup.setListItems(mutableListOf())
    }
}
