package com.bedu.cursos.ui.courses.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bedu.cursos.data.model.Course
import com.bedu.cursos.databinding.CardviewCourseBinding
import com.bedu.cursos.utils.CourseClickListener

class RecyclerAdapter(private var courses: List<Course>,
                      private val clickListener: CourseClickListener
) : RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = CardviewCourseBinding.inflate(view, parent, false)
        return ViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCourse(courses[position])
    }

    override fun getItemCount(): Int = courses.size
}