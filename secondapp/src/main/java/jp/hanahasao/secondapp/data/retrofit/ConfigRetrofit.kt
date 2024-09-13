package jp.hanahasao.secondapp.data.retrofit

import jp.hanahasao.secondapp.data.remote.user.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConfigRetrofit {
    private var retrofit: Retrofit? = null

    private fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    private const val BASE_API_URL = "http://10.49.184.17:8080/api/"

    fun getUserService(): UserService {
        return getRetrofit().create(UserService::class.java)
    }
}