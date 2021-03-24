package com.example.myroomdemo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Insert
    suspend fun insertStudent(student: Student)

    @Query("SELECT * FROM studentTable")
    suspend fun getStudents() : Array<Student>


}