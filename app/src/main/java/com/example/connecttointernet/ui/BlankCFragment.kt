package com.example.connecttointernet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.connecttointernet.R
import com.example.connecttointernet.databinding.FragmentBlankCBinding


class BlankCFragment : Fragment() {

    private lateinit var binding: FragmentBlankCBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankCBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnD.setOnClickListener { v ->
            v.findNavController().navigate(R.id.action_blankCFragment_to_blankDFragment)
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankCFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}