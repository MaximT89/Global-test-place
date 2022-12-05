package com.secondworld.globaltestproject.ui

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.BaseFragment
import com.secondworld.globaltestproject.core.click
import com.secondworld.globaltestproject.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(FragmentMainBinding::inflate) {
    override val viewModel: MainViewModel by viewModels()

    override fun initView() = with(binding) {

        btnSimpleSnackbar.click {
            showSnackbar(message = "Simple snackbar")
        }

        btnCustomPosSnackbar.click {
            showSnackbar(message = "Custom snackbar", type = SnackbarType.POSITIVE)
        }

        btnCustomNegativeSnackbar.click {
            showSnackbar(message = "Custom snackbar", type = SnackbarType.NEGATIVE)
        }
    }

    override fun initObservers() {
    }
}