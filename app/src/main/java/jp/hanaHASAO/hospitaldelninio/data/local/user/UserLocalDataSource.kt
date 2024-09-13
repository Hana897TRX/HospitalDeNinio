package jp.hanaHASAO.hospitaldelninio.data.local.user

import jp.hanaHASAO.hospitaldelninio.data.local.user.entity.UserEntity

interface UserLocalDataSource {
    suspend fun getAllUsers(): List<UserEntity>
}