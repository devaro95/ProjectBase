package com.rmygym.presentation.ui.home.adapter

import android.view.View
import com.rmygym.R
import com.rmygym.presentation.extensions.TypeScale
import com.rmygym.presentation.extensions.formattedWeight
import com.rmygym.presentation.extensions.formattedWeightWithValue
import com.rmygym.presentation.model.MuscleExerciseModel
import es.babel.easymvvm.android.ui.EmaRecyclerAdapter
import kotlinx.android.synthetic.main.item_home_exercise.view.*

class HomeExerciseAdapter(override val listItems: MutableList<MuscleExerciseModel>)  : EmaRecyclerAdapter<MuscleExerciseModel>() {

    override val layoutItemId = R.layout.item_home_exercise

    override fun View.bind(item: MuscleExerciseModel, viewType: Int) {
        ivItemHomeExerciseLogo.setImageResource(item.icon)
        tvItemHomeExerciseName.text = item.title

//        tvItemHomeExerciseWeight.text = item.weight.formattedWeight(TypeScale.THREE_QUARTERS_SCALED)
        //or
        tvItemHomeExerciseWeight.text = item.weight.formattedWeightWithValue(TypeScale.HALF_SCALED)


        tvItemHomeExerciseName.setBackgroundColor(item.type.color)


    }

}