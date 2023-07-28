package com.bedu.cursos.data.api

import com.bedu.cursos.data.model.Course
import com.bedu.cursos.data.model.CourseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.create
import retrofit2.http.GET

interface  ApiService {

    @GET("Curso")
    suspend fun getCourses(): Response<List<CourseResponse>>
    //private val retrofit = ApiHelper.getRetrofit()

    //Llamada que se ejecuta en un hilo secundario

//    suspend fun getCourses(): List<Course> {
//        return withContext(Dispatchers.IO) {
//            val response: Response<List<Course>> =
//                retrofit.create(ApiClient::class.java).getAllCourses()
//            response.body() ?: emptyList()
//        }
//    }
}