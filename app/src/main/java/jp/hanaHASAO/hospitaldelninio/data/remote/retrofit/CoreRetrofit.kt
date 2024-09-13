package jp.hanaHASAO.hospitaldelninio.data.remote.retrofit

import jp.hanaHASAO.hospitaldelninio.data.remote.retrofit.BackendUtils.BASE_API_URL
import jp.hanaHASAO.hospitaldelninio.data.remote.user.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CoreRetrofit {
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

    fun getUserService(): UserService {
        return getRetrofit().create(UserService::class.java)
    }
}

object BackendUtils {
    const val BASE_API_URL = "http://10.49.184.17:8080/api/"
}
