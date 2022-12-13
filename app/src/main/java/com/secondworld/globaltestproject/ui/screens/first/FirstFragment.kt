package com.secondworld.globaltestproject.ui.screens.first

import androidx.fragment.app.viewModels
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.core.extension.hide
import com.secondworld.globaltestproject.core.extension.show
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    private val wordAdapter = WordsAdapter()

    override fun initView() = with(binding) {

        recyclerView.adapter = wordAdapter

        btnAddNewWord.click {
            recyclerView.hide()
            addField.show()
        }

        btnSaveWord.click {
            recyclerView.show()
            addField.hide()

            val enWord = editEnWord.text.toString()
            val ruWord = editRuWord.text.toString()

            viewModel.saveWord(enWord, ruWord)
        }

    }

    override fun initObservers() = with(viewModel){

        listWordsWithTags.observe { list ->
            wordAdapter.items = list
        }
    }


}