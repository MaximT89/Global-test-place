package com.secondworld.globaltestproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.updateText
import com.secondworld.globaltestproject.data.Person
import com.secondworld.globaltestproject.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var bindingFragment: FragmentSecondBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSecondBinding.bind(view)
        bindingFragment = binding

        setFragmentResultListener("key1") { _, bundle ->
            val result = bundle.getString("data1")
            val person = bundle.getParcelable<Person>("data2")
            person?.let { updateText(binding.textTest, it.name) }
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingFragment = null
    }
}