package com.bedu.cursos.data.api

import com.bedu.cursos.utils.Constants.URL_BASE_API
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}