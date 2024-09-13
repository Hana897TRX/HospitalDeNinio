package jp.hanahasao.secondapp.data.remote.user

import jp.hanahasao.secondapp.data.local.user.entity.UserEntity
import jp.hanahasao.secondapp.data.remote.user.service.UserService
import jp.hanahasao.secondapp.data.retrofit.ConfigRetrofit

class UserRemoteDataSourceImp(
    private val userService: UserService = ConfigRetrofit.getUserService(),
): UserRemoteDataSource {
    override suspend fun getAllUsers(): List<UserEntity> {
        return userService.getAllUsers().map { userResponse ->
            UserEntity(
                name = userResponse.name,
                lastName = userResponse.lastName,
                email = userResponse.email,
                age = userResponse.age,
            )
        }
    }
}