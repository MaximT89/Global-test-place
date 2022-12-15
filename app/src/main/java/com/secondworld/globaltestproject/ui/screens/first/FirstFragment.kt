package com.secondworld.globaltestproject.ui.screens.first

import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.bases.BaseFragment
import com.secondworld.globaltestproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding, FirstViewModel>(FragmentFirstBinding::inflate) {
    override val viewModel: FirstViewModel by viewModels()

    private val leftMenuAdapter = LeftMenuAdapter()
    private val mainAdapter = MainContentAdapter()

    override fun initView() = with(binding) {
        createDividerLeftMenu()

        recyclerViewLeftCategory.adapter = leftMenuAdapter
        recyclerViewMainContent.adapter = mainAdapter
    }

    private fun createDividerLeftMenu() {
        val dividerItemDecoration = DividerItemDecoration(requireActivity(), RecyclerView.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(requireActivity(),
            R.drawable.divider_drawable)!!)
        binding.recyclerViewLeftCategory.addItemDecoration(dividerItemDecoration)
    }

    override fun initObservers() = with(viewModel) {

        val manager = GridLayoutManager(requireActivity(), 3)

        manager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return mainAdapter.spansForPosition(position)
            }
        }

        leftMenuAdapter.callBackClick = { activeId ->
            viewModel.changeActiveLeftItem(activeId)
        }

        leftMenuItems.observe { listData ->
            leftMenuAdapter.items = listData

            var activeId : Int? = null
            listData.forEach { data -> if(data.isActive) activeId = data.id }

            viewModel.fetchMainContentItems(activeId)
        }

        listMainContentItems.observe {  list ->
            binding.recyclerViewMainContent.layoutManager = manager
            mainAdapter.items = list
        }
    }
}