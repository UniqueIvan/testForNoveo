package apiTests

import com.fasterxml.jackson.databind.ObjectMapper
import io.restassured.RestAssured
import io.restassured.http.ContentType
import model.request.RegistrationRequest
import model.response.RegistrationResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NewTest {
// Тест без инфраструктуры
    @Test

    fun newTest() {
        val bodyRequest = ObjectMapper().writeValueAsString(
            RegistrationRequest(
                email = "eve.holt@reqres.in",
                password = "pistol"
            )
        )
        val bodyResponse = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(bodyRequest)
            .log().all()
            .`when`()
            .post("https://reqres.in/api/register")
            .then().statusCode(200)
            .extract().response()
            .jsonPath().getObject("", RegistrationResponse::class.java)
        assertThat(bodyResponse.id).isNotNull
        assertThat(bodyResponse.token.length).isEqualTo(17)
    }
}