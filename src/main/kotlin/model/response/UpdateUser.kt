package model.response

data class UpdateUser(
    val job: String,
    val name: String,
    val updatedAt: String
) {
    constructor(): this("", "", "")
}