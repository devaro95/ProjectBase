package com.projectBase.inject

import android.app.Application
import android.content.res.Resources
import com.data.manager.ContextNetworkManager
import com.domain.manager.NetworkManager
import com.domain.manager.ResourceManager
import com.domain.useCase.LoginUseCase
import com.domain.useCase.RegisterUseCase
import com.projectBase.manager.ContextResourceManager
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun generateAppModule(app: Application) = Kodein.Module(name = "AppModule") {

    bind<Application>() with singleton { app }

    bind<Resources>() with singleton { app.resources }

    //UseCase

    bind<LoginUseCase>() with singleton { LoginUseCase(instance()) }

    bind<RegisterUseCase>() with singleton { RegisterUseCase(instance()) }

    //Manager

    bind<ResourceManager>() with singleton { ContextResourceManager(app) }
}
