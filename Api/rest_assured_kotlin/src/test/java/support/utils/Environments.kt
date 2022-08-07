package support.utils

object Environments {
    @JvmStatic
    val environments: String
        get() {
            var environments = System.getProperty("environments")
            if (environments == null) {
                environments = "local"
            }
            return environments
        }
}