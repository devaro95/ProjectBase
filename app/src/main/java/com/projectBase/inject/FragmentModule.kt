package com.projectBase.inject

import androidx.fragment.app.Fragment
import com.projectBase.ui.home.HomeAndroidViewModel
import com.projectBase.ui.home.HomeViewModel
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

    bind<HomeAndroidViewModel>() with singleton { HomeAndroidViewModel(instance()) }

    //NAVIGATION HANDLERS//

}
