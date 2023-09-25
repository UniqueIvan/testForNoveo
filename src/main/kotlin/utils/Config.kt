package utils

import java.io.FileInputStream
import java.util.*

object EnvironmentConfig {
    private val localProperties = Properties()

    init {
        val localPropertiesFile = "local.properties"
        val inputStream = FileInputStream(localPropertiesFile)
        localProperties.load(inputStream)
    }

    val ENV: String = localProperties.getProperty("env", "dev")
}