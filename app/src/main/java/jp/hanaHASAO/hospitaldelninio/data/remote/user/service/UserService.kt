package jp.hanaHASAO.hospitaldelninio.data.remote.user.service

import jp.hanaHASAO.hospitaldelninio.data.remote.user.response.UserResponse
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getAllUsers(): List<UserResponse>
}
