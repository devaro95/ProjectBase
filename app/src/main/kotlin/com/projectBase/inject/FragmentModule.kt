package com.projectBase.inject

import androidx.fragment.app.Fragment
import com.projectBase.ui.home.HomeAndroidViewModel
import com.projectBase.ui.home.HomeViewModel
import com.projectBase.ui.login.LoginAndroidViewModel
import com.projectBase.ui.login.LoginViewModel
import com.projectBase.ui.register.RegisterAndroidViewModel
import com.projectBase.ui.register.RegisterViewModel
import com.projectBase.ui.splash.SplashAndroidViewModel
import com.projectBase.ui.splash.SplashViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun generateFragmentModule(fragment: Fragment) = Kodein.Module(name = "FragmentModule") {

    //FRAGMENT//

    bind<Fragment>() with provider { fragment }

    //FRAGMENT MANAGER//

    //VIEW MODEL//

    bind<HomeViewModel>() with singleton { HomeViewModel() }

    bind<SplashViewModel>() with singleton { SplashViewModel() }

    bind<LoginViewModel>() with singleton { LoginViewModel(instance()) }

    bind<RegisterViewModel>() with singleton { RegisterViewModel(instance()) }

    bind<HomeAndroidViewModel>() with singleton { HomeAndroidViewModel(instance()) }

    bind<SplashAndroidViewModel>() with singleton { SplashAndroidViewModel(instance()) }

    bind<LoginAndroidViewModel>() with singleton { LoginAndroidViewModel(instance()) }

    bind<RegisterAndroidViewModel>() with singleton { RegisterAndroidViewModel(instance()) }

    //NAVIGATION HANDLERS//

}
