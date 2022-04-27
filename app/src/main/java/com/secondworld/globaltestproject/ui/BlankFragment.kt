package com.secondworld.globaltestproject.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone

import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentBlankBinding

class BlankFragment : BaseFragment<FragmentBlankBinding>(FragmentBlankBinding::inflate) {

    private var mainActivity: MainActivity? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = activity as MainActivity?
    }

    override fun onResume() {
        super.onResume()
        if (currentPosition() == 0) binding.imageRemove.isGone = true
        initView()
    }

    private fun initView() {
        binding.currentPosition.text = (currentPosition()?.plus(1)).toString()
        binding.imageAdd.setOnClickListener { mainActivity?.addPage() }
        binding.imageRemove.setOnClickListener { mainActivity?.removePage() }
        binding.createNotification.setOnClickListener {
            notificationAdapter.createNotification((currentPosition()?.plus(1)).toString())
        }
    }

    private fun currentPosition() = mainActivity?.currentPosition()

    companion object {
        fun newInstance() = BlankFragment()
    }
}