package jp.hanaHASAO.hospitaldelninio.data.remote.user.mapper

import jp.hanaHASAO.hospitaldelninio.data.local.user.entity.UserEntity
import jp.hanaHASAO.hospitaldelninio.data.remote.user.response.UserResponse
import java.util.UUID

fun List<UserResponse>.toUserEntityMap(): List<UserEntity> {
    return this.map { user ->
        UserEntity(
            uuid = UUID.randomUUID().toString(),
            name = user.name,
            email = user.email,
            age = user.age,
            lastName = user.lastName,
        )
    }
}
