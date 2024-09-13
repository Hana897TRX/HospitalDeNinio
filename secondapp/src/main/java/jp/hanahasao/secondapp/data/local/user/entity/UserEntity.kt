package jp.hanahasao.secondapp.data.local.user.entity

import java.util.UUID

data class UserEntity(
    val uuid: String = UUID.randomUUID().toString(),
    val name: String = String(),
    val lastName: String = String(),
    val email: String = String(),
    val age: Int = -1,
)
