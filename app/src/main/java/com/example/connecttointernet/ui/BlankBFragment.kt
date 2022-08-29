package com.example.connecttointernet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.connecttointernet.databinding.FragmentBlankBBinding


class BlankBFragment : Fragment() {


    lateinit var binding: FragmentBlankBBinding
    private val args: BlankBFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.textView.text = args.myText
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankBFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}