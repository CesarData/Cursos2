package com.bedu.cursos.ui.courses.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bedu.cursos.data.model.Course
import com.bedu.cursos.domain.UseCases.GetCourse
import com.bedu.cursos.domain.UseCases.GetCourses
import kotlinx.coroutines.launch

class CourseViewModel: ViewModel() {

    val courseViewModel = MutableLiveData<List<Course>>()
    val isLoading = MutableLiveData<Boolean>()

    //Casos de usos
//    var getCoursesUseCase = GetCourses()
//    var getCourseUdeCase = GetCourse()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            isLoading.postValue(false)//////Quitar
//            val result: List<Course>? = getCoursesUseCase()
//            if(!result.isNullOrEmpty()){
//                courseViewModel.postValue(result)
//                isLoading.postValue(false)
//            }
        }
    }

    //Funcion para MuCoursesFragment

//    fun showCourse(){
//        isLoading.postValue(true)
//        val course: Course? = getCourseUdeCase()
//
//        if(course != null){
//            courseViewModel.postValue(course)
//        }
//
//        isLoading.postValue(false)
//    }
}