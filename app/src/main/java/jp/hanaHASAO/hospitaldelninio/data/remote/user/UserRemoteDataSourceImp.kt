package jp.hanaHASAO.hospitaldelninio.data.remote.user

import jp.hanaHASAO.hospitaldelninio.data.remote.retrofit.CoreRetrofit
import jp.hanaHASAO.hospitaldelninio.data.local.user.entity.UserEntity
import jp.hanaHASAO.hospitaldelninio.data.remote.user.mapper.toUserEntityMap
import jp.hanaHASAO.hospitaldelninio.data.remote.user.service.UserService

class UserRemoteDataSourceImp(
    private val userService: UserService = CoreRetrofit.getUserService()
): UserRemoteDataSource {
    override suspend fun getAllUsers(): List<UserEntity> {
        val userResponse = userService.getAllUsers()

        return userResponse.toUserEntityMap()
    }
}
