package com.bedu.cursos.data.api

import com.bedu.cursos.utils.Constants.URL_BASE_API
import com.bedu.cursos.utils.Helpers
import com.bedu.cursos.utils.Helpers.Companion.createUnsafeOkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiHelper {

    val courseService: ApiService =
        Retrofit.Builder()
            .baseUrl(Helpers.URL_BASE_API + "api/")
            .client(createUnsafeOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
//    fun getRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(URL_BASE_API)
//            .client(createUnsafeOkHttpClient())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
}