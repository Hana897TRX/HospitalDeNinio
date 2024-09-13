package jp.hanahasao.secondapp.domain.states

sealed class DomainStates<out T> {
    data object Loading: DomainStates<Nothing>()
    data class Error(val message: String): DomainStates<Nothing>()
    data class Success<out T>(val data: T): DomainStates<T>()
}