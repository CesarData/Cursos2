package com.bedu.cursos.domain.UseCases

import com.bedu.cursos.data.CourseRepositoty
import com.bedu.cursos.data.model.Course

class GetCourses {
    private val repository = CourseRepositoty()
//
//    suspend operator fun invoke(): List<Course>?{
//        return repository.getAllCourses()
//    }
}