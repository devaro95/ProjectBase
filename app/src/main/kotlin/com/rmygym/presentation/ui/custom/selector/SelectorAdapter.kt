package com.rmygym.presentation.ui.custom.selector

import android.view.View
import com.rmygym.R
import com.rmygym.presentation.model.MuscleExerciseModel
import es.babel.easymvvm.android.ui.EmaRecyclerAdapter
import kotlinx.android.synthetic.main.item_selector_muscles.view.*

class SelectorAdapter(override val listItems: MutableList<MuscleExerciseModel>)  : EmaRecyclerAdapter<MuscleExerciseModel>() {

    override val layoutItemId = R.layout.item_selector_muscles

    override fun View.bind(item: MuscleExerciseModel, viewType: Int) {
        ivItemMuscleExercise.setImageDrawable(item.icon)
        tvItemMuscleExercise.text = item.title
    }

}