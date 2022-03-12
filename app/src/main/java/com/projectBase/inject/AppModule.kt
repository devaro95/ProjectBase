package com.projectBase.inject

import android.app.Application
import android.content.res.Resources
import com.data.manager.ContextNetworkManager
import com.domain.manager.NetworkManager
import com.domain.manager.ResourceManager
import com.projectBase.manager.ContextResourceManager
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun generateAppModule(app: Application) = Kodein.Module(name = "AppModule") {

    bind<Application>() with singleton { app }

    bind<Resources>() with singleton { app.resources }

    //UseCase

    //Manager

    bind<ResourceManager>() with singleton { ContextResourceManager(app) }

    bind<NetworkManager>() with singleton { ContextNetworkManager(instance()) }
}
