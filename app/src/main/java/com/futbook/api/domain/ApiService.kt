package com.futbook.api.domain

import com.futbook.api.application.SimpleResponse
import com.futbook.auth.application.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    suspend fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @POST("register")
    fun postRegister(
        @Body body: RequestBody):
            Call<LoginResponse>

    @GET("test")
   //@Headers("Accept: application/json", "Content-Type: application/json", "X-Requested-With: XMLHttpRequest")
    fun getTest(): Call<SimpleResponse>


    @POST("logout")
    fun postLogout(@Header("Authorization") authHeader: String): Call<Void>

    companion object Factory {
        //private const val BASE_URL = "http://10.0.2.2:81/api/"
        private const val BASE_URL = "http://192.168.1.42:81/api/"
        //private const val BASE_URL = "http://geopro.igestionpro.com/api/"

        fun create(): ApiService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}