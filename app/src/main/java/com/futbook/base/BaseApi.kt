package com.futbook.base

import okhttp3.ResponseBody
import retrofit2.http.POST

interface BaseApi {
    interface BaseApi {
        @POST("logout")
        suspend fun logout(): ResponseBody
    }
}