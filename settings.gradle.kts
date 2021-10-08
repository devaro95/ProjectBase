pluginManagement {
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application" ->
                    useModule("com.android.tools.build:gradle:${requested.version}")
                "com.google.gms.google-services" ->
                    useModule("com.google.gms:google-services:${requested.version}")
            }
        }
    }
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "Rmy Gym"

include(":app")
