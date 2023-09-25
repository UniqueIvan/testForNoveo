package model.response

data class RegistrationResponse(
    val id: Int,
    val token: String
) {
    constructor(): this(0, "")
}