package com.rmygym.presentation.di

import android.app.Application
import android.content.res.Resources
import com.rmygym.data.manager.ContextNetworkManager
import com.rmygym.data.net.ErrorHandler
import com.rmygym.data.net.RmyGymErrorHandler
import com.rmygym.domain.manager.NetworkManager
import com.rmygym.domain.manager.ResourceManager
import com.rmygym.presentation.manager.ContextResourceManager
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun generateApplicationModule(app: Application) = Kodein.Module(name = "AppModule") {
    bind<Application>() with singleton { app }

    bind<Resources>() with singleton { app.resources }

    bind<ResourceManager>() with singleton { ContextResourceManager(app) }

    bind<ErrorHandler>() with singleton { RmyGymErrorHandler() }

    bind<NetworkManager>() with singleton { ContextNetworkManager(instance()) }
}
