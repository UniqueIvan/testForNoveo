package apiTests

import ApiTest
import assertk.assertThat
import assertk.assertions.isEqualTo
import com.fasterxml.jackson.databind.ObjectMapper
import io.qameta.allure.Description
import io.qameta.allure.Owner
import io.qameta.allure.Step
import model.request.CreateUser
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.apiReqResIn
import utils.invoke

class UserCRUD {
    @ApiTest
    @Crud
    @Owner("Ivan")
    @DisplayName("Проверка создания User")
    @Test
    @Description("Создание нвого юзера")

    fun userCRUD() {
        val newUserId = createUser()
        updateUser(newUserId)
        deleteUser(newUserId)
    }

    @Step("Удаление юзера")
    private fun deleteUser(newUserId: String) {
        val bodyResponse = apiReqResIn.methodDeleteWithOutBody("/api/users/$newUserId")
        "Проверка , что статус код при удалении записи - 204" {
            assertThat(bodyResponse.statusCode).isEqualTo(204)
        }
    }

    @Step("Обновление данных юзера")
    private fun updateUser(newUserId: String) {
        val updateUser = CreateUser(
            job = "QA-Automation",
            name = "Ivan Ivanov"
        )
        val bodyRequest = ObjectMapper().writeValueAsString(updateUser)
        val bodyResponse = apiReqResIn.methodPut("/api/users/$newUserId", bodyRequest)
            .jsonPath().getObject("", model.response.UpdateUser::class.java)
        "Проверка , что при обновлении данных юзера, все поля и дата записываются корретно" {
            assertThat(bodyResponse.job).isEqualTo(updateUser.job)
            assertThat(bodyResponse.name).isEqualTo(updateUser.name)
        }
    }

    @Step("Создание юзера")
    private fun createUser(): String {
        val newUser = CreateUser(
            job = "QA",
            name = "Ivanov Ivan"
        )
        val requestBody = ObjectMapper().writeValueAsString(newUser)
        val bodyResponse = apiReqResIn.methodPost("/api/users", requestBody).jsonPath()
            .getObject("", model.response.CreateUser::class.java)
        "Проверка , что при создании юзера, все поля и дата записываются корретно" {
            assertThat(bodyResponse.job).isEqualTo(newUser.job)
            assertThat(bodyResponse.name).isEqualTo(newUser.name)
        }
        return bodyResponse.id
    }
}