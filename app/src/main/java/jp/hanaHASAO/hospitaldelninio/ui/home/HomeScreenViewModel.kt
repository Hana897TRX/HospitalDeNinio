package jp.hanaHASAO.hospitaldelninio.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.hanaHASAO.hospitaldelninio.data.local.user.entity.UserEntity
import jp.hanaHASAO.hospitaldelninio.data.remote.user.UserRemoteDataSource
import jp.hanaHASAO.hospitaldelninio.data.remote.user.UserRemoteDataSourceImp
import jp.hanaHASAO.hospitaldelninio.repository.user.UserRepository
import jp.hanaHASAO.hospitaldelninio.repository.user.UserRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val userRepository: UserRepository = UserRepositoryImp(),
): ViewModel() {
    private val _userUIEvent: MutableStateFlow<List<UserEntity>> = MutableStateFlow(listOf())
    val userUIEvent = _userUIEvent.asStateFlow()

    fun getAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        val users = userRepository.getAllUsers()

        _userUIEvent.emit(users)
    }
}
