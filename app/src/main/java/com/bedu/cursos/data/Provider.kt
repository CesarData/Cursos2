package com.bedu.cursos.data

import com.bedu.cursos.data.model.Course

class Provider {
    companion object{
        var courses: List<Course> = emptyList()
    }
}