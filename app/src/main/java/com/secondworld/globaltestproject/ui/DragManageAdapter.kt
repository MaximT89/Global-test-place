package com.secondworld.globaltestproject.ui

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class DragManageAdapter(
    adapter: PersonAdapter,
    dragDirs : Int,
    swipeDirs : Int
) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs){

    var nameAdapter = adapter

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        nameAdapter.swapItems(viewHolder.absoluteAdapterPosition, target.absoluteAdapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }
}