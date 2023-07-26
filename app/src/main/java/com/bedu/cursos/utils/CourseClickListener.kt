package com.bedu.cursos.utils

import com.bedu.cursos.data.model.Course

interface CourseClickListener
{
    fun onClick(course: Course)
}