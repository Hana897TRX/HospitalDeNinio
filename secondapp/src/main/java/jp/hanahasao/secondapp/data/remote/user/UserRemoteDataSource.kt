package jp.hanahasao.secondapp.data.remote.user

import jp.hanahasao.secondapp.data.local.user.entity.UserEntity

interface UserRemoteDataSource {
    suspend fun getAllUsers(): List<UserEntity>
}
