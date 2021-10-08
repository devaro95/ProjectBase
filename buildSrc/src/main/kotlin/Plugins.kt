object Plugins {

    /**
     * Kotlin (version = Kotlin version)
     */
    object KotlinAndroid {
        const val ID = "android"
        const val VERSION = "1.5.0"
    }

    object KotlinAndroidExtensions {
        const val ID = "android.extensions"
        const val VERSION = "1.4.21"
    }

    /**
     * Android (version = Android Gradle Plugin version)
     */
    object AndroidApplication {
        const val ID = "com.android.application"
        const val VERSION = "4.1.2"
    }

    /**
     * Quality
     */
    object Ktlint {
        const val ID = "org.jlleitschuh.gradle.ktlint"
        const val VERSION = "9.4.1"
    }

    object Sonarqube {
        const val ID = "org.sonarqube"
        const val VERSION = "3.1"
    }
}
