package com.example.myroomdemo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myroomdemo.data.Student
import com.example.myroomdemo.data.StudentDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

   // lateinit var studentList : List<StudentView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInsert = findViewById<Button>(R.id.insertBtn)

        btnInsert.setOnClickListener()
        {
            val name = findViewById<TextView>(R.id.nameEditText).text.toString()
            val programme = findViewById<TextView>(R.id.programmeEditText).text.toString()

            val student = Student(0, name,programme)

            val studentDAO = StudentDB.getDatabase(application).studentDAO()

            CoroutineScope(Main).launch {
                    studentDAO.insertStudent(student)
            }
        }

        val btnGetData = findViewById<Button>(R.id.getDataBtn)

        btnGetData.setOnClickListener()
        {
            val studentDAO = StudentDB.getDatabase(application).studentDAO()

            CoroutineScope(Main).launch {
                var studentList: Array<Student> = studentDAO.getStudents()

                val arrStudent = ArrayList<StudentView>()

                if(studentList != null)
                {
                    for (s in studentList){
                        arrStudent += StudentView(s.name, s.programme)
                    }
                }

                val recyclerView : RecyclerView = findViewById(R.id.recycle_view)
                recyclerView.adapter = MyAdapter(arrStudent)
                recyclerView.layoutManager = LinearLayoutManager(application)
                recyclerView.setHasFixedSize(true)

              /*  var nameList: String = ""
                for (s: Student in studentList) {
                    nameList += s.name + "\n"
                }*/

            }
        }
    }
}