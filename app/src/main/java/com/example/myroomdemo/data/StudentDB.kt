package com.example.myroomdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities =[Student::class],version=1,exportSchema = false)
abstract class StudentDB: RoomDatabase() {

    abstract fun studentDAO(): StudentDAO

    companion object{
        private var INSTANCE:StudentDB? = null

        fun getDatabase(context: Context):StudentDB {
            var instance = INSTANCE

            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDB::class.java,
                    "MyDatabase"
                ).fallbackToDestructiveMigration().build()
            }
            return instance
        }
    }

}