package com.bedu.cursos.data.api

import com.bedu.cursos.data.model.Course
import com.bedu.cursos.utils.Constants.PATH
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET(PATH)
    suspend fun getAllCourses(): Response<List<Course>>
}