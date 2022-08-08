package com.secondworld.globaltestproject.ui.fragments

import androidx.navigation.fragment.findNavController
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentSecondBinding
import com.secondworld.globaltestproject.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    override fun initView() = with(binding) {

        if (arguments?.getString("str") != null) {
            textTest.text = arguments?.getString("str")
            arguments?.clear()
//            arguments?.remove("str")
        } else textTest.text = "Ничего не пришло"

        btnNext.setOnClickListener {
            showDialog(
                titleText = "Hello",
                bodyText = "Код ошибки: 400\nЧто то пошло не так",
                callYes = {
                    textTest.text = "Что то случилось"
                },
                callNo = {}
            )
        }
    }

    override fun saveLastFragment() {
        (activity as MainActivity).saveLastFragment(findNavController().currentDestination?.label!!)
    }
}