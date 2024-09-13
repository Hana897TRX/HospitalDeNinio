package jp.hanahasao.secondapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.hanahasao.secondapp.data.local.user.entity.UserEntity
import jp.hanahasao.secondapp.data.remote.user.UserRemoteDataSource
import jp.hanahasao.secondapp.data.remote.user.UserRemoteDataSourceImp
import jp.hanahasao.secondapp.domain.states.DomainStates
import jp.hanahasao.secondapp.domain.user.GetAllUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getAllUsersUseCase: GetAllUsersUseCase = GetAllUsersUseCase(),
): ViewModel() {
    private val _usersUIData: MutableStateFlow<DomainStates<List<UserEntity>>> = MutableStateFlow(DomainStates.Loading)
    val usersUIData = _usersUIData.asStateFlow()

    fun getAllUsers() {
        getAllUsersUseCase().onEach { state ->
            _usersUIData.emit(state)
        }.launchIn(viewModelScope)
    }
}