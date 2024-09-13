package jp.hanaHASAO.hospitaldelninio.data.remote.user.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val name: String = String(),

    @SerializedName("apellido")
    val lastName: String = String(),
    val email: String = String(),

    @SerializedName("edad")
    val age: Int = -1,
)
