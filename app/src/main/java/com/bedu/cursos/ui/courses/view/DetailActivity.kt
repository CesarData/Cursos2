package com.bedu.cursos.ui.courses.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.coroutineScope

import android.transition.Explode

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.view.Window
import com.bedu.cursos.data.model.Course
import com.bedu.cursos.databinding.ActivityDetailBinding
import com.bedu.cursos.utils.CourseClickListener
import com.bedu.cursos.utils.Helpers
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity(), CourseClickListener {

    private lateinit var binding: ActivityDetailBinding


    override fun onClick(course: Course)
    {
        //Lógica al hacer click sobre el detalle del curso
        Log.d("dfragoso94", course.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Habilita la característica de transiciones antes de la creación de la vista
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        // Configura la animación de transición
//        val transition = Explode()
//        window.enterTransition = transition

        //initDatabase(view)
//        val courseID = intent.getStringExtra(Helpers.COURSE_ID)
//        val course = courseID?.let { courseFromID(it.toInt()) }
        val course: Course? = intent.getParcelableExtra(Helpers.COURSE_ITEM)
        val isViewBuy = intent.getBooleanExtra(Helpers.IS_VIEW_BUY, false)
        if(course != null) {
            Picasso.get().load(course.image).into(binding.courseImage)
            binding.tvCourse.text = course.name
            binding.tvPrice.text = "$" + String.format("%.2f", course.price)
            binding.tvDuration.text = String.format("%.2f", course.duration) + " horas"
            binding.rbCalification.rating = course.rating
        }


        binding.buttonBuy.visibility = if(isViewBuy) View.VISIBLE else View.INVISIBLE
//        binding.buttonBuy.setOnClickListener{
//            lifecycle.coroutineScope.launch(Dispatchers.IO) {
//                val user = getUserLogin()
//                if (user != null){
//                    val courseIds = getCourseShopping(user.id)
//                    lifecycle.coroutineScope.launch(Dispatchers.Main) {
//                        if(course != null){
//                            if(courseIds.isEmpty()){
//                                buyCourse(course.id, user.id)
//                                Toast.makeText(applicationContext,"Tienes ${courseIds.size} cursos comprados", Toast.LENGTH_SHORT).show()
//                            }
//                            else{
//                                val bought = courseIds.contains(course.id) //Verificamos si el curso se encuentra en nuestra lista de cursos comprados.
//                                if (!bought){
//                                    buyCourse(course.id, user.id)
//                                    Toast.makeText(applicationContext,"Haz adquirido el curso de ${course.name}", Toast.LENGTH_SHORT).show()
//                                }
//                                else{
//                                    Toast.makeText(applicationContext,"Ya has adquirido este curso", Toast.LENGTH_SHORT).show()
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }

    }

//    private fun initDatabase(view: View){
//        database = Room.databaseBuilder(
//            view.context, ElearningDatabase::class.java, ElearningDatabase.DATABASE_NAME)
//            .allowMainThreadQueries()
//            .fallbackToDestructiveMigrationOnDowngrade()
//            .build()
//    }
//
//    private suspend fun buyCourse(courseID: Int, userID: Int){
//        val request = ShoppingEntity(
//            idUser = userID,
//            idCourse = courseID
//        )
//        database.getUserDao().insertShopping(request)
//    }
//
//    private suspend fun getCourseShopping(idUser: Int): List<Int>{
//        var response = database.getUserDao().getAllShopping(idUser)
//        return response
//    }
//
//    private suspend fun getUserLogin(): UserEntity? {
//        var response = database.getUserDao().getUserLogin()
//        return response
//    }

//    private fun courseFromID(courseID: Int): Course? {
//
//        for(course in listCourses) {
//            if(course.id == courseID)
//                return course
//        }
//        return null
//    }

    override fun onBackPressed() {
        finish()
    }
}