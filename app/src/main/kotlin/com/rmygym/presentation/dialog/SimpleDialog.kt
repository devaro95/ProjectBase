package com.rmygym.presentation.dialog

import android.view.View
import androidx.fragment.app.FragmentManager
import com.rmygym.R
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialogProvider
import es.babel.easymvvm.core.constants.STRING_EMPTY
import es.babel.easymvvm.core.dialog.EmaDialogData

class SimpleDialog : EmaBaseDialog<SimpleDialog.Data>() {

    override val layoutId: Int = R.layout.dialog_simple

    override fun setupData(data: Data, view: View) {
        //Nothing to do
    }

    data class Data(
        val title: String = STRING_EMPTY,
        override val proportionWidth: Float? = null,
        override val proportionHeight: Float? = null
    ) : EmaDialogData

    class Provider(fragmentManager: FragmentManager) : EmaBaseDialogProvider(fragmentManager) {
        override fun generateDialog(): EmaBaseDialog<*> = SimpleDialog()
    }
}