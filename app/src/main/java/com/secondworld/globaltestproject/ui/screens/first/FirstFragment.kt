package com.secondworld.globaltestproject.ui.screens.first

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("SetTextI18n")
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    override fun initView() = with(binding){
        btnConnectSocket.click(viewModel::connectWebSocket)

        btnSendMessage.click { viewModel.sendMessageToSocket(editTextToSocket.text.toString()) }

        btnCloseSocket.click { viewModel.onClose()}
    }

    override fun initObservers() = with(viewModel) {
        messageFromSocket.observe { message ->
            binding.textFromSocket.text = "Message : $message"
        }

        messageInfo.observe { message ->
            binding.textInfoFromSocket.text = "Info : $message"
        }
    }
}