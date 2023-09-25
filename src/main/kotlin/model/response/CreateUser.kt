package model.response

data class CreateUser(
    val createdAt: String,
    val id: String,
    val job: String,
    val name: String
) {
    constructor(): this("", "", "", "")
}