package com.projectBase.ui.home

import androidx.compose.runtime.Composable
import com.carmabs.ema.android.viewmodel.EmaAndroidViewModel
import com.carmabs.ema.core.state.EmaExtraData
import com.domain.model.MuscleExerciseModel
import com.projectBase.R
import com.projectBase.base.BaseFragment
import com.projectBase.ui.main.MainNavigator
import org.kodein.di.generic.instance

class HomeViewFragment : BaseFragment<HomeState, HomeViewModel, MainNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_home

    override val navigator: MainNavigator by instance()

    override val viewModelSeed: HomeViewModel by instance()

    override val androidViewModelSeed: EmaAndroidViewModel<HomeViewModel> by instance<HomeAndroidViewModel>()

    override fun onSingleEvent(data: EmaExtraData) {

    }

    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onError(error: Throwable) {

    }

    @Composable
    override fun OnNormal(data: HomeState) {
        HomeScreen(homeState = HomeState(
            mutableListOf(
                MuscleExerciseModel(MuscleExerciseModel.MuscleGroupType.CHEST, "", 0, 0.0),
                MuscleExerciseModel(MuscleExerciseModel.MuscleGroupType.CHEST, "", 0, 0.0),
                MuscleExerciseModel(MuscleExerciseModel.MuscleGroupType.CHEST, "", 0, 0.0),
                MuscleExerciseModel(MuscleExerciseModel.MuscleGroupType.CHEST, "", 0, 0.0),
                MuscleExerciseModel(MuscleExerciseModel.MuscleGroupType.CHEST, "", 0, 0.0),
                MuscleExerciseModel(MuscleExerciseModel.MuscleGroupType.CHEST, "", 0, 0.0))
        )
        )
    }

}
