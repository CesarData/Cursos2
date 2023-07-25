package com.bedu.cursos.ui.main.view

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
//import com.bedu.cursos.ui.main.view.HomeFragmentDirections
import com.bedu.cursos.R
//import com.bedu.cursos.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    //private lateinit var binding: HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding = HomeFragmentBinding.bind(view)

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        val btnCourses = view.findViewById<Button>(R.id.button_courses)
        btnCourses?.setOnClickListener{
        //binding.buttonCourses.setOnClickListener {
            findNavController().navigate(R.id.flow_step_one_dest, null, options)
        }

        val btnMyCourses = view.findViewById<Button>(R.id.button_my_courses)
        //binding.buttonMyCourses.setOnClickListener {
        btnMyCourses?.setOnClickListener {
            findNavController().navigate(R.id.flow_step_two_dest, null, options)
        }

        val btnAction = view.findViewById<Button>(R.id.navigate_action_button)
        //binding.navigateActionButton.setOnClickListener {
        btnAction?.setOnClickListener {
            //findNavController().navigate(R.id.next_action, null, options)
            val flowStepNumberArg = 2
            val action = HomeFragmentDirections.nextAction(flowStepNumberArg)
            findNavController().navigate(action)
        }
    }
}
