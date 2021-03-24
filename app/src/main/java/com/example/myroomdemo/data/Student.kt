package com.example.myroomdemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "studentTable")
data class Student (

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val programme:String)