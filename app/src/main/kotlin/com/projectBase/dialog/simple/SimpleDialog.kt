package com.projectBase.dialog.simple

import android.view.View
import androidx.fragment.app.FragmentManager
import com.carmabs.ema.android.ui.dialog.EmaBaseDialog
import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.dialog.EmaDialogData
import com.projectBase.R

class SimpleDialog : EmaBaseDialog<SimpleDialog.Data>() {

    override val layoutId: Int = R.layout.dialog_simple

    override fun createInitialState(): Data {
        return Data()
    }

    override fun View.setup(data: Data) {

    }

    data class Data(
        val title: String = STRING_EMPTY,
        override val proportionWidth: Float? = null,
        override val proportionHeight: Float? = null,
    ) : EmaDialogData

    //Todo()
    /*class Provider(fragmentManager: FragmentManager) : EmaBaseDialogProvider(fragmentManager) {
        override fun generateDialog(): EmaBaseDialog<*> = SimpleDialog()
    }

     */
}