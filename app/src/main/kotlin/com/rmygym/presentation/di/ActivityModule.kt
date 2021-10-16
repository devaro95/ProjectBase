package com.rmygym.presentation.di

import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import com.rmygym.presentation.base.BaseActivity
import com.rmygym.presentation.dialog.SimpleDialog
import com.rmygym.presentation.ui.login.LoginNavigator
import com.rmygym.presentation.ui.main.MainNavigator
import com.rmygym.presentation.ui.main.MainViewModel
import com.rmygym.presentation.ui.main.MainViewState
import com.rmygym.presentation.ui.splash.SplashNavigator
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun injectionActivityModule(activity: BaseActivity) = Kodein.Module(name = "ActivityModule") {

    bind<NavController>() with singleton { activity.navController }

    bind<FragmentManager>() with provider { activity.supportFragmentManager }

    bind<MainViewModel>() with singleton { MainViewModel() }

    bind<MainViewState>() with singleton { MainViewState() }

    /** Dialogs **/

    bind<SimpleDialog.Provider>() with provider { SimpleDialog.Provider(instance()) }

    /** Navigators **/

    bind<MainNavigator>() with singleton { MainNavigator(instance()) }

    bind<SplashNavigator>() with singleton { SplashNavigator(instance()) }

    bind<LoginNavigator>() with singleton { LoginNavigator(instance()) }
}
