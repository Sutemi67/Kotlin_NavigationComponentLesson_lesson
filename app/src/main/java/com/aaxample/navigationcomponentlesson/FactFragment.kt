package com.aaxample.navigationcomponentlesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aaxample.navigationcomponentlesson.databinding.FragmentFactBinding


class FactFragment : Fragment() {
    private lateinit var binding: FragmentFactBinding
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARGS_FACT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFactBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fact = requireArguments().getString(ARGS_FACT)
        val image = if (fact.equals("Cat fact")) {
            R.drawable.vat1
        } else {
            R.drawable.hams1
        }
        binding.factText.text = fact

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.nextButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_factFragment_to_imageFragment,
                ImageFragment.createArgs(image)
            )
        }
    }

    companion object {
        const val ARGS_FACT = "fact"

        @JvmStatic
        fun newInstance(param1: String) =
            FactFragment().apply {
                arguments = Bundle().apply {
                    putString(ARGS_FACT, param1)
                }
            }

        fun createArgs(fact: String): Bundle = bundleOf(ARGS_FACT to fact)
    }
}