package jp.hanaHASAO.hospitaldelninio.repository.user

import jp.hanaHASAO.hospitaldelninio.data.local.user.entity.UserEntity

interface UserRepository {
    suspend fun getAllUsers(): List<UserEntity>
}