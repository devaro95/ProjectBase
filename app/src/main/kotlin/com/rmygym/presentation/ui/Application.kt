package com.rmygym.presentation.ui

import com.rmygym.BuildConfig
import com.rmygym.data.di.generateDataModule
import com.rmygym.presentation.di.generateApplicationModule
import es.babel.easymvvm.android.base.EmaApplication
import org.kodein.di.Kodein
import timber.log.Timber

class Application : EmaApplication() {

    override val kodein: Kodein
        get() = super.kodein.apply { Kodein }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun injectAppModule(kodein: Kodein.MainBuilder): Kodein.Module {
        kodein.import(generateDataModule())
        return generateApplicationModule(this)
    }
}
