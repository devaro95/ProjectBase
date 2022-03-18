package com.projectBase.base

import com.carmabs.ema.android.base.EmaApplication
import com.data.injection.generateDataModule
import com.projectBase.inject.generateAppModule
import org.kodein.di.Kodein

class Application : EmaApplication() {

    override fun injectAppModule(kodeinBuilder: Kodein.MainBuilder): Kodein.Module = setupAppModules(kodeinBuilder)

    override val kodein: Kodein = super.kodein.apply { Kodein }

    private fun setupAppModules(kodein: Kodein.MainBuilder): Kodein.Module {
        kodein.import((generateDataModule()))
        return generateAppModule(this)
    }
}