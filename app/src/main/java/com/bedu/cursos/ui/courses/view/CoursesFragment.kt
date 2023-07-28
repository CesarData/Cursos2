package com.bedu.cursos.ui.courses.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedu.cursos.R
import com.bedu.cursos.data.api.ApiClient
import com.bedu.cursos.data.api.ApiHelper
import com.bedu.cursos.data.model.Course
import com.bedu.cursos.data.model.CourseResponse
import com.bedu.cursos.databinding.CoursesFragmentBinding
import com.bedu.cursos.ui.courses.adapter.RecyclerAdapter
import com.bedu.cursos.ui.courses.view.CoursesFragmentArgs
import com.bedu.cursos.ui.courses.viewmodel.CourseViewModel
import com.bedu.cursos.utils.Constants
import com.bedu.cursos.utils.Constants.COURSE_ID
import com.bedu.cursos.utils.CourseClickListener
import com.bedu.cursos.utils.Helpers
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoursesFragment : Fragment(), CourseClickListener {

    private lateinit var binding: CoursesFragmentBinding
    private val courseViewModel: CourseViewModel by viewModels()


    private lateinit var contexto: Context
    private var listCourses: List<Course> = listOf()
    private lateinit var shimmerViewContainer: ShimmerFrameLayout

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            contexto = context
        } catch (e: ClassCastException) {
            throw ClassCastException("$context debe implementar ParametrosListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CoursesFragmentBinding.bind(view)
        val courseFragment = this
        //var coursesFiltered: List<Course>




        courseViewModel.onCreate()

        if(Helpers.isInternetAvailable(contexto)){
            //Obtenemos la lista de cursos de la Api
            CoroutineScope(Dispatchers.IO).launch {
                val deferred = async { getCourses() }
                val response = deferred.await()
                if(response != null)
                {
                    withContext(Dispatchers.Main) {
                        //binding.shimmerViewContainer.stopShimmer()
                        Toast.makeText(
                            context,
                            "Los cursos se obtuvieron correctamente..",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    listCourses = Helpers.convertListDataClass(contexto, response)

                    CoroutineScope(Dispatchers.Main).launch {
                        //val courseFragment = this
                        var coursesFiltered: List<Course>

                        binding.recycler.apply {
                            layoutManager = LinearLayoutManager(view.context)
                            adapter = RecyclerAdapter(listCourses, this@CoursesFragment) //courseFragment
                        }

                        binding.buttonAll.setOnClickListener{
                            binding.recycler.adapter = RecyclerAdapter(listCourses, this@CoursesFragment) //this
                        }

                        binding.buttonDesign.setOnClickListener{
                            coursesFiltered = listCourses.filter { c -> c.category.contains("Diseño") }
                            binding.recycler.adapter = RecyclerAdapter(coursesFiltered, this@CoursesFragment) //this
                        }

                        binding.buttonProg.setOnClickListener {
                            coursesFiltered = listCourses.filter { c -> c.category.contains("Programación") }
                            binding.recycler.adapter = RecyclerAdapter(coursesFiltered, this@CoursesFragment) //this
                        }

                        binding.buttonWeb.setOnClickListener {
                            coursesFiltered = listCourses.filter { c -> c.category.contains("Desarrollo Web") }
                            binding.recycler.adapter = RecyclerAdapter(coursesFiltered,this@CoursesFragment)// { course -> onItemSelected(course) }) //this
                        }
                        //binding.shimmerViewContainer.visibility = View.INVISIBLE
                    }
                }
                else
                {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            contexto,
                            "Algo falló en la API.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        else
        {
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(
                    contexto,
                    "No hay conexión a internet.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    private fun onItemSelected(course: Course){
        try{
            //Log.d("dfragoso94",course.toString())
            val activity = contexto //requireActivity()
            val intent = Intent(activity, DetailActivity::class.java)
            requireActivity().overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
            //intent.putExtra(Helpers.COURSE_ID, course.id.toString())
            intent.putExtra(Helpers.COURSE_ITEM, course)
            intent.putExtra(Helpers.IS_VIEW_BUY, true)
            activity.startActivity(intent)
        }
        catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun getCourses(): List<CourseResponse>?{
        var response: List<CourseResponse>? = null

        try
        {
            var result = ApiHelper.courseService.getCourses()
            response = result.body()
            //Log.d("dfragoso94", response.toString())
        }
        catch (e: Exception)
        {
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    contexto,
                    e.message.toString(), //"Error de la API",
                    Toast.LENGTH_LONG
                ).show()
            }
           // Log.d("dfragoso94", e.message.toString())
        }
        return response
    }
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