package com.rmygym.presentation.ui.custom.selector

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.GridLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.rmygym.R
import com.rmygym.presentation.model.MuscleExerciseModel
import kotlinx.android.synthetic.main.custom_selector_layout_view.view.*

class CustomSelectorExerciseView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.selectorExerciseStyle) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    //TODO Recordar al churri Alvaro quitar las cosas de Babel
    //Y que me de permiso para meterme en las tareas de Jira

    var labelTitle: CharSequence? = null
        set(value) {
            tvCustomSelectorTitle.text = value
            field = value
        }

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.CustomSelectorExerciseView, 0, 0)
            applyAttrs(typedArray)
            typedArray.recycle()
        }
    }

    private fun applyAttrs(attributes: TypedArray) {
        with(attributes) {
            labelTitle = getString(R.styleable.CustomSelectorExerciseView_labelTitle)
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        prepareView()
    }

    private fun prepareView(){
        rvSelectorGroup.layoutManager = GridLayoutManager(context, NUMBER_COLUMNS)
    }

    fun setListItems(items: MutableList<MuscleExerciseModel>){
        rvSelectorGroup.adapter = SelectorAdapter(items)
    }

    companion object{
        const val NUMBER_COLUMNS = 4
    }

}
