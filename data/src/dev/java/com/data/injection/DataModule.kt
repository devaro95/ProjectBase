package com.data.injection

import com.carmabs.ema.core.concurrency.AsyncManager
import com.carmabs.ema.core.concurrency.ConcurrencyManager
import com.carmabs.ema.core.concurrency.DefaultAsyncManager
import com.carmabs.ema.core.concurrency.DefaultConcurrencyManager
import com.data.repository.NetworkRepository
import com.domain.repository.Repository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun generateDataModule() = Kodein.Module(name = "DataModule") {

    bind<Repository>() with singleton { NetworkRepository() }

    bind<AsyncManager>() with singleton { DefaultAsyncManager() }

    bind<ConcurrencyManager>() with singleton { DefaultConcurrencyManager() }
}