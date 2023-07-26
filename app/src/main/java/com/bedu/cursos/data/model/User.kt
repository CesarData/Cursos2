package com.bedu.cursos.data.model

data class User(
    val name: String,
    val email: String,
    var mobileNumber: String,
    var password: String,
    var courses: MutableList<Course> = mutableListOf()
)
