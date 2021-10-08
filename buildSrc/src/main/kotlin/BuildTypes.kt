interface BuildType {
    val isMinifyEnabled: Boolean
    val isTestCoverageEnabled: Boolean

    companion object {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }
}

object BuildTypes {
    object Debug : BuildType {
        override val isMinifyEnabled = false
        override val isTestCoverageEnabled = true
    }

    object Release : BuildType {
        override val isMinifyEnabled = true
        override val isTestCoverageEnabled = false

        object Proguard {
            const val DEFAULT_FILE = "proguard-android.txt"
            const val FILE = "proguard-rules.pro"
        }
    }
}