package jp.hanahasao.secondapp.domain.user

import jp.hanahasao.secondapp.data.remote.user.UserRemoteDataSource
import jp.hanahasao.secondapp.data.remote.user.UserRemoteDataSourceImp
import jp.hanahasao.secondapp.domain.states.DomainStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetAllUsersUseCase(
    private val remoteDataSource: UserRemoteDataSource = UserRemoteDataSourceImp(),
) {
    operator fun invoke() = flow {
        try {
            emit(DomainStates.Loading)
            delay(2000)
            val users = remoteDataSource.getAllUsers()
            emit(DomainStates.Success(users))
        } catch (e: Exception) {
            emit(DomainStates.Error(e.message ?: "An unexpected error occurred"))
        }
    }.flowOn(Dispatchers.IO)
}