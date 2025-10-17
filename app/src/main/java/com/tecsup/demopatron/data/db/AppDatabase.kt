package com.tecsup.demopatron.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tecsup.demopatron.data.dao.InstructorDao
import com.tecsup.demopatron.data.model. Instructor

@Database (entities=[Instructor::class], version=1, exportSchema=false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun instructorDao(): InstructorDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "demopatron.db"
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}