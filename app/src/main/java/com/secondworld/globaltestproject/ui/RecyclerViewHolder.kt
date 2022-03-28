package com.secondworld.globaltestproject.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.secondworld.globaltestproject.data.models.Person
import com.secondworld.globaltestproject.data.models.Student
import com.secondworld.globaltestproject.databinding.PersonHolderBinding
import com.secondworld.globaltestproject.databinding.StudentHolderBinding

sealed class RecyclerViewHolder(binding : ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    var callBackTest : ((view : View, item : RecyclerViewItem, position : Int) -> Unit)? = null

    class PersonHolder(private val binding: PersonHolderBinding) : RecyclerViewHolder(binding){
        fun bind(person : Person){
            binding.personName.text = person.name
            binding.personAge.text = person.age.toString()
        }
    }

    class StudentHolder(private val binding: StudentHolderBinding) : RecyclerViewHolder(binding){
        fun bind(student: Student){
            binding.studentName.text = student.name
            binding.studentAge.text = student.age.toString()
            binding.studentCourse.text = student.course.toString()
            binding.btnTest.setOnClickListener {
                callBackTest?.invoke(it, student, absoluteAdapterPosition)
            }
        }
    }

}