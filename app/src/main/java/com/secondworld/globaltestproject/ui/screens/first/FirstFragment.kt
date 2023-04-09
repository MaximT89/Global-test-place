package com.secondworld.globaltestproject.ui.screens.first

import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import com.secondworld.globaltestproject.logic.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(
        FragmentFirstBinding::inflate, FirstViewModel::class.java
    ) {

    override fun initView() {}

    fun source1(newData : HandlerOut<Animal>) {
        var n1 : HandlerOut<Empty> = newData
        var n2 : HandlerOut<Animal> = newData
        var n3 : HandlerOut<Tiger> = newData
    }

    fun source2(s : HandlerIn<Animal>) {
        s.compareTo(Empty("sd"))
        s.compareTo(Animal("sd"))
        s.compareTo(Tiger("sd"))
    }

    override fun initObservers() = Unit

}

