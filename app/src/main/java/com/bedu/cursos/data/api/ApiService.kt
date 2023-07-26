package com.bedu.cursos.data.api

import com.bedu.cursos.data.model.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.create

class ApiService {
    private val retrofit = ApiHelper.getRetrofit()

    //Llamada que se ejecuta en un hilo secundario

    suspend fun getCourses(): List<Course> {
        return withContext(Dispatchers.IO) {
            val response: Response<List<Course>> =
                retrofit.create(ApiClient::class.java).getAllCourses()
            response.body() ?: emptyList()
        }
    }
}