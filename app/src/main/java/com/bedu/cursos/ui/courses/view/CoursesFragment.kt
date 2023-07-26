package com.bedu.cursos.ui.courses.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedu.cursos.R
import com.bedu.cursos.data.model.Course
import com.bedu.cursos.databinding.CoursesFragmentBinding
import com.bedu.cursos.ui.courses.adapter.RecyclerAdapter
import com.bedu.cursos.ui.courses.view.CoursesFragmentArgs
import com.bedu.cursos.ui.courses.viewmodel.CourseViewModel
import com.bedu.cursos.utils.Constants.COURSE_ID
import com.bedu.cursos.utils.CourseClickListener

class CoursesFragment : Fragment(), CourseClickListener {

    private lateinit var binding: CoursesFragmentBinding
    private val courseViewModel: CourseViewModel by viewModels()

    override fun onClick(course: Course)
    {
        val bundle = Bundle()
        bundle.putInt(COURSE_ID, course.id)
        findNavController().navigate(R.id.flow_my_courses_dest, bundle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.courses_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CoursesFragmentBinding.bind(view)
        val courseFragment = this
        //var coursesFiltered: List<Course>

        courseViewModel.onCreate()
//
//        courseViewModel.courseViewModel.observe(viewLifecycleOwner, Observer {
//            binding.recycler.apply {
//                layoutManager = LinearLayoutManager(view.context)
//                adapter = RecyclerAdapter(it, courseFragment)
//            }
//        })
//
//        courseViewModel.isLoading.observe(viewLifecycleOwner, Observer {status ->
//            binding.progressCircular.isVisible = status
//        })

//        binding.recycler.apply {
//            layoutManager = LinearLayoutManager(view.context)
//            adapter = RecyclerAdapter(listCourses, courseFragment)
//        }

//        binding.buttonAll.setOnClickListener{
//            binding.recycler.adapter = RecyclerAdapter(listCourses, this)
//        }
//
//        binding.buttonDesign.setOnClickListener{
//            coursesFiltered = listCourses.filter { c -> c.category.contains("Diseño") }
//            binding.recycler.adapter = RecyclerAdapter(coursesFiltered, this)
//        }
//
//        binding.buttonProgrammation.setOnClickListener {
//            coursesFiltered = listCourses.filter { c -> c.category.contains("Programación") }
//            binding.recycler.adapter = RecyclerAdapter(coursesFiltered, this)
//        }
//
//        binding.buttonWeb.setOnClickListener {
//            coursesFiltered = listCourses.filter { c -> c.category.contains("Desarrollo Web") }
//            binding.recycler.adapter = RecyclerAdapter(coursesFiltered, this)
//        }
    }
}