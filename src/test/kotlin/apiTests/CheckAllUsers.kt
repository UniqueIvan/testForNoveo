package apiTests

import ApiTest
import io.qameta.allure.Owner
import model.response.Data
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.apiReqResIn
import utils.step

class CheckAllUsers {
    @ApiTest
    @AllUsers
    @Owner("IvanNumberOne")
    @Test
    @DisplayName("Проверка получения всех пользователей")

    fun checkAllUsersNew() {
        step("Проверка , что почта всех пользователей заканчивается на \"@reqres.ing\"") {
            val bodyResponse = apiReqResIn.methodGetWithParam("/api/users", mutableMapOf("page" to 2))
            val userList = bodyResponse.jsonPath().getList("data", Data::class.java)

            userList.map {
                assertThat(it.email).endsWith("@reqres.in")
            }
        }
    }
}


