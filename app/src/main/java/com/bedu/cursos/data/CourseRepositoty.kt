package com.bedu.cursos.data

import com.bedu.cursos.data.api.ApiService
import com.bedu.cursos.data.model.Course

class CourseRepositoty {

    private val api = ApiService()

    suspend fun getAllCourses():List<Course>{
        val response: List<Course> = api.getCourses()
        Provider.courses = response
        return response
    }
}