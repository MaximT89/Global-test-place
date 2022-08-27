package com.secondworld.globaltestproject.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.viewbinding.ViewBinding
import com.secondworld.globaltestproject.R

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

open class BaseFragment<B : ViewBinding>(private val inflate: Inflate<B>) : Fragment() {

    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }

    fun navigate(destination: Navigator) {

        findNavController().navigate(destination.id,
            null,
            navOptions {
                anim {
                    enter = R.anim.slide_in_left
                    exit = R.anim.slide_in_right
                    popEnter = R.anim.slide_in_left_pop
                    popExit = R.anim.slide_in_right_pop
                }
            })


//        findNavController().navigate(destination.id,
//            null,
//            navOptions {
//                anim {
//                    enter = R.anim.slide_in_left
//                    exit = R.anim.slide_in_right
//                    popEnter = R.anim.slide_in_left_pop
//                    popExit = R.anim.slide_in_right_pop
//                }
//            })
    }

    fun navigateBack(){
        findNavController().navigateUp()
    }
}