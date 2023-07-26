package com.bedu.cursos.ui.courses.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bedu.cursos.R
import com.bedu.cursos.databinding.MyCoursesFragmentBinding
//import com.bedu.cursos.ui.courses.view.CoursesFragmentArgs

class MyCoursesFragment : Fragment() {

    private lateinit var binding: MyCoursesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.my_courses_fragment, container, false)///////////
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = MyCoursesFragmentBinding.bind(view)

        binding.nextButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.next_action)
        )
    }
}