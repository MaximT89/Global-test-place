package com.secondworld.globaltestproject

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.AnimationSet
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.core.animateLikeButton
import com.secondworld.globaltestproject.core.snackbar
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private var bindingFragment: FragmentFirstBinding? = null

    @SuppressLint("Recycle")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFirstBinding.bind(view)
        bindingFragment = binding

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        binding.textShadow.animateLikeButton()

    }


    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }
}