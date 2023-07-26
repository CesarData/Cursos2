package com.bedu.cursos.ui.courses.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bedu.cursos.data.model.Course
import com.bedu.cursos.databinding.CardviewCourseBinding
import com.bedu.cursos.utils.CourseClickListener


class ViewHolder(private val cardviewCourseBinding: CardviewCourseBinding,
                 private val clickListener: CourseClickListener
)
    : RecyclerView.ViewHolder(cardviewCourseBinding.root){

    fun bindCourse(course: Course){
        cardviewCourseBinding.courseImage.setImageResource(course.image)
        cardviewCourseBinding.tvCourse.text = course.name
        cardviewCourseBinding.tvPrice.text = "$" + String.format("%.2f", course.price)
        cardviewCourseBinding.tvHours.text = " "
        cardviewCourseBinding.rbCalification.rating = course.rating

        cardviewCourseBinding.cardviewLayout.setOnClickListener{
            clickListener.onClick(course)
        }
    }
}