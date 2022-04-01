package com.data.injection

import com.carmabs.ema.core.concurrency.AsyncManager
import com.carmabs.ema.core.concurrency.ConcurrencyManager
import com.carmabs.ema.core.concurrency.DefaultAsyncManager
import com.carmabs.ema.core.concurrency.DefaultConcurrencyManager
import com.data.manager.ContextNetworkManager
import com.data.net.ErrorHandler
import com.data.net.RMyGymErrorHandler
import com.data.repository.MockApiRepository
import com.data.repository.NetworkRepository
import com.domain.manager.NetworkManager
import com.domain.repository.Repository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun generateDataModule() = Kodein.Module(name = "DataModule") {

    bind<NetworkManager>() with singleton { ContextNetworkManager(instance()) }

    bind<Repository>() with singleton { MockApiRepository() }

    bind<AsyncManager>() with singleton { DefaultAsyncManager() }

    bind<ConcurrencyManager>() with singleton { DefaultConcurrencyManager() }
}