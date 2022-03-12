package com.projectBase.inject

import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import com.projectBase.base.BaseActivity
import com.projectBase.ui.main.MainNavigator
import com.projectBase.ui.main.MainViewModel
import com.projectBase.ui.splash.SplashNavigator
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun injectionActivityModule(activity: BaseActivity) = Kodein.Module(name = "ActivityModule") {

    bind<MainViewModel>() with provider { MainViewModel() }

    bind<FragmentManager>() with provider { activity.supportFragmentManager }

    //ACTIVITY//

    bind<BaseActivity>() with singleton { activity }

    //NAV CONTROLLER//

    bind<NavController>() with singleton { activity.navController }

    //MANAGER


    //NAVIGATOR//
    bind<SplashNavigator>() with singleton { SplashNavigator(instance(), instance()) }

    bind<MainNavigator>() with singleton { MainNavigator() }

    //DIALOG//

    //Todo()
    // bind<SimpleDialog.Provider>() with provider { SimpleDialog.Provider(instance()) }
}
