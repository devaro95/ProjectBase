package com.rmygym.presentation.di

import androidx.fragment.app.Fragment
import com.rmygym.presentation.ui.home.HomeViewModel
import com.rmygym.presentation.ui.login.LoginViewModel
import com.rmygym.presentation.ui.register.RegisterViewModel
import com.rmygym.presentation.ui.splash.SplashViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun generateFragmentModule(fragment: Fragment) = Kodein.Module(name = "FragmentModule") {
    bind<Fragment>() with provider { fragment }

    bind<SplashViewModel>() with singleton { SplashViewModel() }

    bind<HomeViewModel>() with singleton { HomeViewModel() }

    bind<RegisterViewModel>() with singleton { RegisterViewModel(instance()) }

    bind<LoginViewModel>() with singleton { LoginViewModel(instance()) }
}
