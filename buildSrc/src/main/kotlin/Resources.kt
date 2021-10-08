interface Resource {
    val type: String
    val name: String
}

object Resources {
    object ApplicationName : Resource {
        override val type: String = "string"
        override val name: String = "app_name"
    }
}