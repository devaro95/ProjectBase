object Android {
    const val COMPILE_SDK_VERSION = 30

    object DefaultConfig {
        const val APPLICATION_ID = "com.rmygym"
        const val APPLICATION_NAME = "RMy Gym"
        const val MIN_SDK_VERSION = 26
        const val TARGET_SDK_VERSION = 30
        const val VERSION_CODE = 1
        const val VERSION_NAME = "0.1"
        const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    }

    object LintOptions {
        const val WARNINGS_AS_ERRORS = true
        object Disabled {
            const val OVERDRAW = "Overdraw"
        }
    }

    object SourceSet {
        const val SRC_DIR = "src/%s/kotlin"
    }
}
