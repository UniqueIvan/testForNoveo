package utils

import utils.EnvironmentConfig.ENV

val REQ_RES_IN =
    when (ENV) {
        "dev" -> "https://master-reqres.in.dev/"
        "prod" -> "https://reqres.in/"
        else -> IllegalArgumentException("Неверно указано окружение")
    }