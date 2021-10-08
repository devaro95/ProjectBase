package com.rmygym.data.di

import com.rmygym.data.manager.AppVersionManager
import com.rmygym.data.manager.ContextLocationManager
import com.rmygym.data.manager.ContextPreferencesManager
import com.rmygym.data.repository.CacheNetworkRepository
import com.rmygym.domain.manager.LocationManager
import com.rmygym.domain.manager.PreferencesManager
import com.rmygym.domain.manager.VersionManager
import com.rmygym.domain.repository.NetworkRepository
import es.babel.easymvvm.core.concurrency.AsyncManager
import es.babel.easymvvm.core.concurrency.ConcurrencyManager
import es.babel.easymvvm.core.concurrency.DefaultAsyncManager
import es.babel.easymvvm.core.concurrency.DefaultConcurrencyManager
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun generateDataModule() = Kodein.Module(name = "DataModule") {
    bind<NetworkRepository>() with singleton {
        CacheNetworkRepository(
            com.rmygym.data.repository.NetworkRepository(
                instance(),
                instance()
            )
        )
    }

    bind<VersionManager>() with singleton { AppVersionManager() }

    bind<AsyncManager>() with singleton { DefaultAsyncManager() }

    bind<LocationManager>() with singleton { ContextLocationManager(instance()) }

    bind<ConcurrencyManager>() with singleton { DefaultConcurrencyManager() }

    bind<PreferencesManager>() with singleton { ContextPreferencesManager(instance()) }
}
