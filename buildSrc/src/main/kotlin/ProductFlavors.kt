interface ProductFlavor {
    val dimension: String
    val name: String
    val applicationIdSuffix: String? get() = ".$name"
    val applicationName: String get() = "${Android.DefaultConfig.APPLICATION_NAME} $name"

    companion object {
        object Dimensions {
            const val ENVIRONMENT = "environment"
        }
    }
}

object ProductFlavors {
    object Mock : ProductFlavor {
        override val dimension: String = ProductFlavor.Companion.Dimensions.ENVIRONMENT
        override val name: String = "mock"
    }

    object Dev : ProductFlavor {
        override val dimension: String = ProductFlavor.Companion.Dimensions.ENVIRONMENT
        override val name: String = "dev"
    }

    object Pro : ProductFlavor {
        override val dimension: String = ProductFlavor.Companion.Dimensions.ENVIRONMENT
        override val name: String = "pro"
        override val applicationIdSuffix: String? = null
    }
}