package jp.hanaHASAO.hospitaldelninio.data.local.user.entity

data class UserEntity(
    val uuid: String = String(),
    val name: String = String(),
    val lastName: String = String(),
    val email: String = String(),
    val age: Int = -1,
)
