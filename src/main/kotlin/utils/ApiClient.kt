package utils

import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.Filter
import io.restassured.filter.log.LogDetail
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.response.Response

open class ApiClient(
    private val baseUrl: String,
    private val requestLoggingFilter: Filter = RequestLoggingFilter(),
    private val responseLoggingFilter: Filter = ResponseLoggingFilter(),
    private val allureLoggingFilter: Filter? = AllureRestAssured(),
) {

    private var send = RequestSpecBuilder()
        .addFilter(requestLoggingFilter)
        .addFilter(responseLoggingFilter)
        .addFilter(allureLoggingFilter)
        .setBaseUri(baseUrl)
        .setContentType(ContentType.JSON)
        .log(LogDetail.ALL)
    // Логирование всех деталей запроса и ответа

    fun methodGet(path: String): Response {
        val reqSpec = send.build()
        return RestAssured.given().spec(reqSpec).get(path)
            .then()
            .log().all()
            .extract().response()
    }

    fun methodGetWithParam(path: String, param: MutableMap<String, Any>): Response {
        val reqSpec = send.addQueryParams(param).build()
        return RestAssured.given().spec(reqSpec).get(path)
            .then()
            .log().all()
            .extract().response()
    }

    fun methodPost(path: String, request: Any): Response {
        val reqSpec = send.setBody(request).build()
        return RestAssured.given().spec(reqSpec).post(path)
            .then()
            .log().all()
            .extract().response()
    }

    fun methodPut(path: String, request: Any): Response {
        val reqSpec = send.setBody(request).build()
        return RestAssured.given().spec(reqSpec).put(path)
            .then()
            .log().all()
            .extract().response()
    }

    fun methodDeleteWithOutBody(path: String): Response {
        val reqSpec = send.build()
        return RestAssured.given().spec(reqSpec).delete(path)
            .then()
            .log().all()
            .extract().response()
    }
}
