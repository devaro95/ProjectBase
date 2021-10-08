package com.rmygym.presentation.base

import android.app.Activity
import android.content.Intent
import com.rmygym.presentation.di.injectionActivityModule
import com.rmygym.presentation.model.ActivityResultHandlerModel
import es.babel.easymvvm.android.ui.EmaFragmentActivity
import org.kodein.di.Kodein

abstract class BaseActivity : EmaFragmentActivity() {

    private val resultHandler: HashMap<Int, ActivityResultHandlerModel> = HashMap()

    override fun injectActivityModule(kodein: Kodein.MainBuilder): Kodein.Module =
        injectionActivityModule(this)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val remove = resultHandler[requestCode]?.implementation?.invoke(
            requestCode,
            parseResultCode(resultCode),
            data
        ) ?: false
        if (remove) removeActivityResultHandler(requestCode)
    }

    fun addActivityResultHandler(activityResultHandlerModel: ActivityResultHandlerModel) {
        resultHandler[activityResultHandlerModel.id] = activityResultHandlerModel
    }

    fun removeActivityResultHandler(id: Int) {
        resultHandler.remove(id)
    }

    private fun parseResultCode(code: Int): ActivityResultHandlerModel.Result {
        return when (code) {
            Activity.RESULT_OK -> ActivityResultHandlerModel.Result.Success
            Activity.RESULT_CANCELED -> ActivityResultHandlerModel.Result.Fail
            else -> ActivityResultHandlerModel.Result.Other(code)
        }
    }
}
