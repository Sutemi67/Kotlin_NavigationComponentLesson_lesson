package com.aaxample.navigationcomponentlesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aaxample.navigationcomponentlesson.databinding.FragmentStartBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.catPathButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_startFragment_to_factFragment,
                FactFragment.createArgs("Cat fact")
            )
        }
        binding.hamsterPathButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_startFragment_to_factFragment,
                FactFragment.createArgs("Hamster fact")
            )
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}