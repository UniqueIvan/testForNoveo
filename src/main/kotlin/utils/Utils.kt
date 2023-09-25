package utils

import io.qameta.allure.Step

operator fun String.invoke(action: () -> Unit) {
    action()
}

@Step("Выполнение шага: {0}")
fun step(description: String, action: () -> Unit) {
    action()
}