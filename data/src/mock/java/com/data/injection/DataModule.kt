package com.data.injection

import es.babel.easymvvm.core.concurrency.AsyncManager
import es.babel.easymvvm.core.concurrency.ConcurrencyManager
import es.babel.easymvvm.core.concurrency.DefaultAsyncManager
import es.babel.easymvvm.core.concurrency.DefaultConcurrencyManager
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun generateDataModule() = Kodein.Module(name = "DataModule") {

    bind<AsyncManager>() with singleton { DefaultAsyncManager() }

    bind<ConcurrencyManager>() with singleton { DefaultConcurrencyManager() }
}