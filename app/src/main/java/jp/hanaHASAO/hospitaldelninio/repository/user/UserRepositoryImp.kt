package jp.hanaHASAO.hospitaldelninio.repository.user

import jp.hanaHASAO.hospitaldelninio.data.local.user.entity.UserEntity
import jp.hanaHASAO.hospitaldelninio.data.local.user.UserLocalDataSource
import jp.hanaHASAO.hospitaldelninio.data.local.user.UserLocalDataSourceImp
import jp.hanaHASAO.hospitaldelninio.data.remote.user.UserRemoteDataSource
import jp.hanaHASAO.hospitaldelninio.data.remote.user.UserRemoteDataSourceImp

class UserRepositoryImp(
    private val userRemoteDataSource: UserRemoteDataSource = UserRemoteDataSourceImp(),
    private val userLocalDataSource: UserLocalDataSource = UserLocalDataSourceImp(),
): UserRepository {
    override suspend fun getAllUsers(): List<UserEntity> {
        return try {
            val data = userRemoteDataSource.getAllUsers()
            data.ifEmpty { userLocalDataSource.getAllUsers() }
        } catch (e: Exception) {
            userLocalDataSource.getAllUsers()
        }
    }
}