package com.projectBase.base

import com.carmabs.ema.android.ui.EmaFragmentActivity
import com.projectBase.inject.injectionActivityModule
import org.kodein.di.Kodein

abstract class BaseActivity : EmaFragmentActivity() {

    override fun injectActivityModule(kodein: Kodein.MainBuilder): Kodein.Module = injectionActivityModule(this)

}