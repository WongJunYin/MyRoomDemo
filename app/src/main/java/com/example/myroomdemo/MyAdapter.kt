package com.example.myroomdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val studentList : List<StudentView>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemViwe : View) : RecyclerView.ViewHolder(itemViwe){
        val studentName : TextView = itemViwe.findViewById(R.id.tvStudentName)
        val studentProgramme : TextView = itemViwe.findViewById(R.id.tvStudentProgramme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]

        holder.studentName.setText(currentItem.name)
        holder.studentProgramme.setText(currentItem.programe)
    }
}