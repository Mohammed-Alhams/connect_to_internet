package com.example.connecttointernet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.connecttointernet.R
import com.example.connecttointernet.databinding.FragmentBlankABinding


class BlankAFragment : Fragment() {

    private lateinit var binding: FragmentBlankABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankABinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnB.setOnClickListener { v ->
            val dirToB = BlankAFragmentDirections
                .actionBlankAFragmentToBlankBFragment("hello from A")

            v.findNavController().navigate(dirToB)
        }

        binding.btnC.setOnClickListener { v ->
            v.findNavController().navigate(R.id.action_blankAFragment_to_blankCFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankAFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}