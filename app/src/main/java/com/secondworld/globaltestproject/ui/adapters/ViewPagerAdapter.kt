package com.secondworld.globaltestproject.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.secondworld.globaltestproject.ui.fragments.FirstFragment
import com.secondworld.globaltestproject.ui.fragments.SecondFragment
import com.secondworld.globaltestproject.ui.fragments.ThirdFragment

class ViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> FirstFragment()
        }
    }
}