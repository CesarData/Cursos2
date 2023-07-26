package com.bedu.cursos.ui.main.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
//import com.bedu.cursos.ui.main.view.HomeFragmentDirections
import com.bedu.cursos.R
import com.bedu.cursos.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
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

        binding = HomeFragmentBinding.bind(view)

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        binding.buttonCourses.setOnClickListener {
            findNavController().navigate(R.id.flow_courses_dest, null, options)
        }

        binding.buttonMyCourses.setOnClickListener {
            findNavController().navigate(R.id.home_to_my_courses_dest, null, options)
        }

//        binding.navigateActionButton.setOnClickListener {
//            //findNavController().navigate(R.id.next_action, null, options)
//            val flowNumberArg = 1
//            val action = HomeFragmentDirections.nextAction(flowNumberArg)
//            findNavController().navigate(action)
//        }
    }
}
