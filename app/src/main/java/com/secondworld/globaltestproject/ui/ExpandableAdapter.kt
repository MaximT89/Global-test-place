package com.secondworld.globaltestproject.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.secondworld.globaltestproject.R

class ExpandableAdapter(
    private var ctx: Context,
    childList: ArrayList<ArrayList<String>>,
    private val parents: Array<String>
) : BaseExpandableListAdapter() {

    init {
        childLists = childList

    }

    override fun getGroupCount(): Int {
        return childLists.size
    }

    override fun getChildrenCount(parent: Int): Int {
        return parents.size
    }

    override fun getGroup(parent: Int): Any {

        return parents[parent]
    }

    override fun getChild(parent: Int, child: Int): Any {
        return childLists[parent][child]
    }

    override fun getGroupId(parent: Int): Long {
        return parent.toLong()
    }

    override fun getChildId(parent: Int, child: Int): Long {
        return child.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(parent: Int, isExpanded: Boolean, convertView: View?, parentview: ViewGroup): View {
        var convertView = convertView

        if (convertView == null) {
            val inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.parent_layout, parentview, false)

        }

        val parent_textvew = convertView!!.findViewById(R.id.parent_txt) as TextView
        parent_textvew.text = parents[parent]
        return convertView
    }

    override fun getChildView(
        parent: Int,
        child: Int,
        isLastChild: Boolean,
        convertView: View?,
        parentview: ViewGroup
    ): View {
        var convertView = convertView

        if (convertView == null) {
            val inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.child_layout, parentview, false)

        }

        val child_textvew = convertView!!.findViewById(R.id.child_txt) as TextView
        child_textvew.text = getChild(parent, child).toString()
        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }

    companion object {
        lateinit var childLists: ArrayList<ArrayList<String>>
    }
}