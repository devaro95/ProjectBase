object Dependencies {
    private object Versions {
        /**
         * Android
         */
        const val KTX = "1.3.2"
        const val APPCOMPAT = "1.2.0"
        const val CONSTRAINT_LAYOUT = "2.0.4"
        const val BIOMETRIC = "1.0.1"
        const val VIEW_PAGER = "1.0.0"

        /**
         * Core
         */
        const val KOTLIN = "1.5.0"
        const val COROUTINES = "1.3.9"
        const val KODEIN = "6.5.5"
        const val TIMBER = "4.7.1"

        /**
         * Google
         */
        const val MATERIAL = "1.2.1"
        const val PLAY_SERVICES = "17.0.0"
        const val ANALYTICS = "18.0.1"
        const val MESSAGING = "21.0.1"

        /**
         * EMA
         */
        const val EMA = "2.4.0"

        /**
         * HTTP & Retrofit
         */
        const val RETROFIT = "2.9.0"
        const val COROUTINES_ADAPTER = "0.9.2"
        const val LOGGING_INTERCEPTOR = "4.9.0"

        /**
         * Media
         */
        const val PICASSO = "2.8"
        const val LOTTIE = "3.4.0"

        /**
         * Testing
         */
        const val ARCH = "2.0.0"
    }

    /**
     * Android
     */
    const val KTX = "androidx.core:core-ktx:${Versions.KTX}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val BIOMETRIC = "androidx.biometric:biometric:${Versions.BIOMETRIC}"
    const val VIEW_PAGER = "androidx.viewpager2:viewpager2:${Versions.VIEW_PAGER}"

    /**
     * Core
     */
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val KODEIN = "org.kodein.di:kodein-di-generic-jvm:${Versions.KODEIN}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"

    /**
     * Google
     */
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val MAPS = "com.google.android.gms:play-services-maps:${Versions.PLAY_SERVICES}"
    const val LOCATION = "com.google.android.gms:play-services-location:${Versions.PLAY_SERVICES}"
    const val MESSAGING = "com.google.firebase:firebase-messaging:${Versions.MESSAGING}"

    /**
     * EMA
     */
    const val EMA = "com.github.babel-cdm.ema:easymvvm-core:${Versions.EMA}"
    const val EMA_ANDROID = "com.github.babel-cdm.ema:easymvvm-android:${Versions.EMA}"

    /**
     * HTTP & Retrofit
     */
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val SCALARS = "com.squareup.retrofit2:converter-scalars:${Versions.RETROFIT}"
    const val COROUTINES_ADAPTER =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.COROUTINES_ADAPTER}"
    const val LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTOR}"


    /**
     * Images and GIFs
     */
    const val PICASSO = "com.squareup.picasso:picasso:${Versions.PICASSO}"
    const val LOTTIE = "com.airbnb.android:lottie:${Versions.LOTTIE}"

    /**
     * Testing
     */
    const val ARCH = "android.arch.core:core-testing:${Versions.ARCH}"
    const val EMA_TESTING = "com.github.babel-cdm.ema:easymvvm-testing-core:${Versions.EMA}"
}
