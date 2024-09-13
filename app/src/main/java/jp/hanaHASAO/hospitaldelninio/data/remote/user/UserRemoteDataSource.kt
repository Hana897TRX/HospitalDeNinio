package jp.hanaHASAO.hospitaldelninio.data.remote.user

import jp.hanaHASAO.hospitaldelninio.data.local.user.entity.UserEntity

interface UserRemoteDataSource {
    suspend fun getAllUsers(): List<UserEntity>
}