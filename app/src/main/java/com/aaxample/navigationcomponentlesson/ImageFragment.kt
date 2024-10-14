package com.aaxample.navigationcomponentlesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aaxample.navigationcomponentlesson.databinding.FragmentImageBinding


class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.image.animation =
            AnimationUtils.loadAnimation(context, R.anim.fade_in)
        binding.image.animate()

        binding.image.setImageResource(
            requireArguments().getInt(IMAGE_PARAM)
        )
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.goToStartButton.setOnClickListener {
            findNavController().popBackStack(R.id.startFragment, false)
        }
    }

    companion object {

        const val IMAGE_PARAM = "image"

        fun createArgs(param: Int): Bundle = bundleOf(IMAGE_PARAM to param)
    }
}